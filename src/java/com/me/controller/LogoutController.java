/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Administrator
 */
public class LogoutController extends AbstractController {
    
    public LogoutController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        

        request.setAttribute("successful", "Log Out Successfully"); 
        
        return new ModelAndView("index");
        //return new ModelAndView("redirect:"+viewPage);
    }
}
