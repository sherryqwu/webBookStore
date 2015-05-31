package com.me.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.me.DAO.CartDAO;
import com.me.DAO.UserDAO;
import com.me.pojo.Cart;
import com.me.pojo.User;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Sherry
 */
public class RegisterController extends SimpleFormController {
    
    public RegisterController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        User user = (User) command;
        user.setIdentity(1);
        UserDAO userDao = new UserDAO();
        userDao.create(user);
        
        Cart newCart = new Cart();
        newCart.setUserid(user.getId());
        CartDAO cartDao = new CartDAO();
        cartDao.create(newCart);
        user.setCart(newCart);
        cartDao.close();
        userDao.create(user);
        userDao.close();
    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     @Override
     protected ModelAndView onSubmit(
     HttpServletRequest request, 
     HttpServletResponse response, 
     Object command, 
     BindException errors) throws Exception {
     ModelAndView mv = new ModelAndView(getSuccessView());
     //Do something...
     return mv;
     }
     */
}
