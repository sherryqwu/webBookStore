/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import com.me.DAO.AdException;
import com.me.DAO.BookDAO;

/**
 *
 * @author Sherry
 */
public class CartItem {
    private int itemid;
    private int bookid;
    private Cart cart;
    private int quantity;

    public int getItemid() {
        return itemid;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Book getBook() throws AdException{
        BookDAO bookDao = new BookDAO();
        return bookDao.get(String.valueOf(bookid));
    }
}
