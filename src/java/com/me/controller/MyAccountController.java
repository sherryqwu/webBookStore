/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.UserDAO;
import com.me.pojo.User;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Sherry
 */
public class MyAccountController extends SimpleFormController {
    
    public MyAccountController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        
    }
    
    @Override
     protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        User user = (User) command;
        
        UserDAO userDao = new UserDAO();
        User temp = userDao.get(user.getUserName(), user.getPassWord());
        UserDAO.close();
        
        if(user.getRemember() !=null){
            Cookie cookies = new Cookie("userName",user.getUserName());
            cookies.setMaxAge(300);
            response.addCookie(cookies);
            
            Cookie cookies1 = new Cookie("passWord",user.getPassWord());
            cookies1.setMaxAge(300);
            response.addCookie(cookies1);

        } 
         
        
        request.getSession().setAttribute("user", temp);
        request.getSession().setAttribute("authentication","yes");
         return new ModelAndView("index");
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
    
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        User user = new User();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("userName")){
                user.setUserName(cookie.getValue());
            }
            else if(cookie.getName().equals("passWord")){
                user.setPassWord(cookie.getValue());
            }
        }
        return user;
    }
 /*   
        @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
      User user = (User) request.getSession().getAttribute("user");
      if (user==null){
          request.setAttribute("errormessage","Illegal access");
          return new ModelAndView("error");
      }
      return new ModelAndView(getFormView(),getCommandName(),new User());
    }
    * */
}
