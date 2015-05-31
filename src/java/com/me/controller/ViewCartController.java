/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.AddressDAO;
import com.me.DAO.CartDAO;
import com.me.pojo.Address;
import com.me.pojo.Cart;
import com.me.pojo.CartItem;
import com.me.pojo.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sherry
 */
public class ViewCartController extends AbstractController {
    
    public ViewCartController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
          request.setAttribute("errormessage","Illegal access");
          return new ModelAndView("error");

      }
        CartDAO cartDao = new CartDAO();
        //Cart cart = cartDao.getByUserId(user.getId());
        int temp = user.getCart().getCartid();
        Cart cart = cartDao.getByCartID(temp);
        
        AddressDAO addDao = new AddressDAO();
        ArrayList<Address> adds = addDao.getAllAddress(user.getId());
        //ArrayList<CartItem> items = user.getCart().getItems();
        request.setAttribute("adds", adds);     
        return new ModelAndView("cart","cart",cart);
    }
}
