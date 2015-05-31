/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.BookDAO;
import com.me.pojo.Book;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sherry
 */
public class CategoryController extends AbstractController {
    
    public CategoryController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        BookDAO bookDao = new BookDAO();
        ArrayList<Book> books = bookDao.getAllBook();
        request.setAttribute("books", books);
        return new ModelAndView("category");
       // throw new UnsupportedOperationException("Not yet implemented");
    }
}
