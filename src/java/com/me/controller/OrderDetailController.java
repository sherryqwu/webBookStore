/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.CartDAO;
import com.me.pojo.Cart;
import com.me.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sherry
 */
public class OrderDetailController extends AbstractController {
    
    public OrderDetailController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
         User user = (User) request.getSession().getAttribute("user");
        if (user==null){
          request.setAttribute("errormessage","Illegal access");
          return new ModelAndView("error");

      }
        String cartid = request.getParameter("cartid");
        CartDAO cartDao = new CartDAO();
        Cart cart = cartDao.getByCartID(Integer.parseInt(cartid));
        return new ModelAndView("orderHistoryDetail","cart",cart);
    }
}
