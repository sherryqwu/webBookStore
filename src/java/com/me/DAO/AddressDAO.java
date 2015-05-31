/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import com.me.pojo.Address;
import com.me.pojo.CartItem;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Sherry
 */
public class AddressDAO extends DAO{
    public AddressDAO(){
    }
    
     public Address create(Address add)
            throws AdException {
        //try {
            begin();
            getSession().saveOrUpdate(add);
            commit();
            return add;
     }
     
     
       public ArrayList<Address> getAllAddress(int userid)
            throws AdException {
        ArrayList<Address> adds = new ArrayList<Address>();
        try {
            begin();
            Query q = getSession().createQuery("from Address where userID = :UserId");
            q.setString("UserId", String.valueOf(userid));
            Iterator iterate = q.iterate();
            while(iterate.hasNext()){
                adds.add((Address)iterate.next());
            }
            commit();
            return adds;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get address " , e);
        }
     
       }
       
        public Address get(String addid)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Address where addressID = :addid");
            q.setString("addid", addid);
            Address add = (Address) q.uniqueResult();
            commit();
            return add;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get book " + addid, e);
        }
    }
}
