/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import com.me.pojo.Cart;
import com.me.pojo.User;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Sherry
 */
public class CartDAO extends DAO{
    public CartDAO() {
    }

    public Cart getByCartID(int cartid)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Cart where cartid = :CartID" );
            q.setString("CartID", String.valueOf(cartid));
            Cart cart = (Cart) q.uniqueResult();
            commit();
            return cart;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get User " + cartid, e);
        }
    }
    
    public Cart getByUserID(int userid)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Cart where userid = :UserID" );
            q.setString("UserID", String.valueOf(userid));
            Cart cart = (Cart) q.uniqueResult();
            commit();
            if(cart ==null){
                Cart temp = new Cart();
                temp.setUserid(userid);
                cart = create(temp); 
            }
            return cart;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get User " + userid, e);
        }
    }
    
    public ArrayList<User> getAllUser()
            throws AdException {
        ArrayList<User> Users = new ArrayList<User>();
        try {
            begin();
            Query q = getSession().createQuery("from User");
            Iterator iterate = q.iterate();
            while(iterate.hasNext()){
                Users.add((User)iterate.next());
            }
            commit();
            return Users;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get User " , e);
        }
        
    }

    public Cart create(Cart cart)
            throws AdException {
        //try {
            begin();
            getSession().save(cart);
            commit();
            return cart;
        //} catch (HibernateException e) {
          //  rollback();
            //throw new AdException("Could not create User " + Username, e);
          //  throw new AdException("Exception while creating User: " + e.getMessage());
        //}
    }

    public void delete(User User)
            throws AdException {
        try {
            begin();
            getSession().delete(User);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete User " + User.getUserName(), e);
        }
    }
}
