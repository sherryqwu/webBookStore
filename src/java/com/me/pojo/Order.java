/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;


import com.me.DAO.AdException;
import com.me.DAO.CartDAO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Order {
        private int orderid;
        private int userid;
        private int cartid;
        private int addressid;
        private String orderTime;
        private String status;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }



    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }
    
    public Cart getCart() throws AdException{
        CartDAO cartDao = new CartDAO();
        Cart cart = cartDao.getByCartID(cartid);
        return cart;
    }
              
}
