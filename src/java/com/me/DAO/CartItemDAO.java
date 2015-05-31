/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import com.me.pojo.Cart;
import com.me.pojo.CartItem;
import com.me.pojo.User;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Sherry
 */
public class CartItemDAO extends DAO{
    public CartItemDAO() {
    }

    public CartItem get(String cartItemid)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from CartItem where itemid = :CartItemId" );
            q.setString("CartItemId", cartItemid);
            CartItem cartItem = (CartItem) q.uniqueResult();
            commit();
            return cartItem;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get User " + cartItemid, e);
        }
    }
    
    public ArrayList<CartItem> getAllCartItem(int cartid)
            throws AdException {
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        try {
            begin();
            Query q = getSession().createQuery("from CartItem where cartid = :CartId");
            q.setString("CartId", String.valueOf(cartid));
            Iterator iterate = q.iterate();
            while(iterate.hasNext()){
                cartItems.add((CartItem)iterate.next());
            }
            commit();
            return cartItems;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get CartItem " , e);
        }
        
    }

    public CartItem create(CartItem cartItem)
            throws AdException {
        //try {
            begin();
            getSession().saveOrUpdate(cartItem);
            commit();
            return cartItem;
        //} catch (HibernateException e) {
          //  rollback();
            //throw new AdException("Could not create User " + Username, e);
          //  throw new AdException("Exception while creating User: " + e.getMessage());
        //}
    }

    public CartItem update(CartItem cartItem)
            throws AdException {
        //try {
            begin();
            getSession().update(cartItem);
            commit();
            return cartItem;
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

    public CartItem get(int cartid, String bookid) throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from CartItem where cartid = :CartId and bookid = :BookId" );
            q.setString("CartId", String.valueOf(cartid));
            q.setString("BookId", String.valueOf(bookid));
            
            CartItem cartItem = (CartItem) q.uniqueResult();
            commit();
            return cartItem;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get User " + cartid, e);
        }
    }
}
