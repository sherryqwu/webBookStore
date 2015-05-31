package com.me.pojo;

import com.me.DAO.AdException;
import com.me.DAO.CartDAO;

public class User {
	private int id;
	private String userName;
//	private String Name;
//	private String sex;
	private String passWord;
//	private String card;
	private String Email;
	private String phone;
//	private String regtime;
	private int identity;
        private Cart cart;
        
        private String remember;
    /*    
    public User() throws AdException{
        Cart newCart = new Cart();
        newCart.setUserid(id);
        CartDAO cartDao = new CartDAO();
        cartDao.create(newCart);
        cart = newCart;
        cartDao.close();
    }    */
        
    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
    
    
 /*   public Cart getCart() throws AdException{
        CartDAO cartDao= new CartDAO();
        Cart temp = cartDao.get(id);
        return temp;
    }
 */

    public Cart getCart() throws AdException {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
