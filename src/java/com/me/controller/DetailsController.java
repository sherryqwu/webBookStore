/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.BookDAO;
import com.me.pojo.Book;
import com.me.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sherry
 */
public class DetailsController extends AbstractController {
    
    public DetailsController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    
      BookDAO bookDao = new BookDAO();
      Book temp = bookDao.get(request.getParameter("id"));
      request.setAttribute("book", temp); 
      //  request.getSession().setAttribute("user", temp);
         return new ModelAndView("details");
    }
}
