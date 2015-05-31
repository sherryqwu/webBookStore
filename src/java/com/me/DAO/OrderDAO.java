/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import com.me.pojo.Cart;
import com.me.pojo.Order;
import com.me.pojo.User;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Sherry
 */
public class OrderDAO extends DAO{
    public OrderDAO(){
    }
    
        public Order saveOrder(Order order)
            throws AdException {
        //try {
            begin();
            getSession().save(order);
            commit();
            return order;
        }   
        
     public ArrayList<Order> getOrderHistory(int userid)
            throws AdException {
        try {
            ArrayList<Order> orders = new ArrayList<Order>();
            begin();
            Query q = getSession().createQuery("from Order where userid = :UserID" );
            q.setString("UserID", String.valueOf(userid));
            Iterator iterate = q.iterate();
            while(iterate.hasNext()){
                orders.add((Order)iterate.next());
            }
            commit();
            return orders;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get User " + userid, e);
        }
    }

}
