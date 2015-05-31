/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import com.me.DAO.AdException;
import com.me.DAO.CartDAO;
import com.me.DAO.CartItemDAO;
import java.util.ArrayList;

/**
 *
 * @author Sherry
 */
public class Cart {

    private int cartid;
    private int userid;

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public ArrayList<CartItem> getItems() throws AdException {
        CartItemDAO ciDao = new CartItemDAO();
        ArrayList<CartItem> items = ciDao.getAllCartItem(cartid);
        return items;
    }
/*
    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }
    */ 

    public int getCount() throws AdException {
        CartItemDAO cartItemDao = new CartItemDAO();
        ArrayList<CartItem> items = cartItemDao.getAllCartItem(cartid);
        if (items == null) {
            //CartItemDAO ciDao = new CartItemDAO();
            //items = ciDao.getAllCartItem(cartid);
            return 0;
        }
        int count = 0;
        for (CartItem ci : items) {
              count = count + ci.getQuantity();
            
        }
        return count;
    }

    public float getTotalPrice() throws AdException {
        float price = 0;
        CartItemDAO cartItemDao = new CartItemDAO();
        ArrayList<CartItem> items = cartItemDao.getAllCartItem(cartid);
        if (items == null) {
            CartItemDAO ciDao = new CartItemDAO();
            items = ciDao.getAllCartItem(cartid);
        }
        if (items == null) {
            return price;
        }
        
        for (CartItem ci : items) {
            price += ci.getQuantity() * ci.getBook().getPrice();
        }
        return price;
    }
}
