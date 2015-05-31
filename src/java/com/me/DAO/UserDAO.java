/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import com.me.pojo.User;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Sherry
 */
public class UserDAO extends DAO{
    public UserDAO() {
    }

    public User get(String username, String password)
            throws AdException {
        //try {
            begin();
            Query q = getSession().createQuery("from User where userName = :Username and passWord = :Password" );
            q.setString("Username", username);
            q.setString("Password", password);
            User User = (User) q.uniqueResult();
            commit();
            return User;
        /*} catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get User " + username, e);
        }*/
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

    public User create(User user)
            throws AdException {
        //try {
            begin();
            getSession().saveOrUpdate(user);
            commit();
            return user;
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
