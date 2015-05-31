package com.me.DAO;

import com.me.pojo.Book;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;


public class BookDAO extends DAO {

    public BookDAO() {
    }

    public Book get(String bookid)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Book where id = :bookid");
            q.setString("bookid", bookid);
            Book book = (Book) q.uniqueResult();
            commit();
            return book;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get book " + bookid, e);
        }
    }
    
    public ArrayList<Book> getAllBook()
            throws AdException {
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            begin();
            Query q = getSession().createQuery("from Book");
            Iterator iterate = q.iterate();
            while(iterate.hasNext()){
                books.add((Book)iterate.next());
            }
            commit();
            return books;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get book " , e);
        }
        
    }

     public ArrayList<Book> getSpecialBook()
            throws AdException {
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            begin();
            Query q = getSession().createQuery("from Book where typeid = 4");
            Iterator iterate = q.iterate();
            while(iterate.hasNext()){
                books.add((Book)iterate.next());
            }
            commit();
            return books;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get book " , e);
        }
        
    }
    public Book create(Book book)
            throws AdException {
        //try {
            begin();
            getSession().save(book);
            commit();
            return book;
        /*} catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create book " + bookname, e);
            throw new AdException("Exception while creating book: " + e.getMessage());
        }*/
    }

    public void delete(Book book)
            throws AdException {
        try {
            begin();   
            getSession().delete(book);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete book " + book.getName(), e);
        }
    }
}
