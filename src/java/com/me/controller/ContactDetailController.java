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
 * @author Sherry
 */
public class ContactDetailController extends AbstractController {
    
    public ContactDetailController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        SendMail.sendMail(request.getParameter("email"),request.getParameter("name") ,request.getParameter("subject"),request.getParameter("message"));
        return new ModelAndView("success", "successmessage", "Your message has been sent!");
    }
}
