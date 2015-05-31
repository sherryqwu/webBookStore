/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.BookDAO;
import com.me.pojo.Book;
import com.me.pojo.User;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Sherry
 */
public class AddBookController extends SimpleFormController {
    
    public AddBookController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        Book book = (Book) command;
        BookDAO bookDao = new BookDAO();
        CommonsMultipartFile commonsFile = book.getImage();
        book.setImagefile("images/"+commonsFile.getOriginalFilename());
        bookDao.create(book);
        bookDao.close();
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
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
      User user = (User) request.getSession().getAttribute("user");
      if (user==null){
          request.setAttribute("errormessage","You are not validated. Admin only");
          return new ModelAndView("error");
      }
      return new ModelAndView(getFormView(),getCommandName(),new Book());
    }
}
