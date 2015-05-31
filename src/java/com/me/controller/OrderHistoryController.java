/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.OrderDAO;
import com.me.pojo.Order;
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
public class OrderHistoryController extends AbstractController {
    
    public OrderHistoryController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
          request.setAttribute("errormessage","Illegal access");
          return new ModelAndView("error");

      }
        
        OrderDAO orderDao = new OrderDAO();
        ArrayList<Order> orderHistory = orderDao.getOrderHistory(user.getId());
        return new ModelAndView("orderHistory","orderHistory",orderHistory);
    }
}
