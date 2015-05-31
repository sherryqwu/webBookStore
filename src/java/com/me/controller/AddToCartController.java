/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.BookDAO;
import com.me.DAO.CartItemDAO;
import com.me.pojo.Book;
import com.me.pojo.Cart;
import com.me.pojo.CartItem;
import com.me.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sherry
 */
public class AddToCartController extends AbstractController {
    
    public AddToCartController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
      User user = (User) request.getSession().getAttribute("user");
      if (user==null){
          request.setAttribute("errormessage","You have not <a href='myaccount.htm'>loged in</a>");
          return new ModelAndView("error");

      }
      else{
      BookDAO bookDao = new BookDAO();
      Book temp = bookDao.get(request.getParameter("bookid"));
      String bookid = request.getParameter("bookid");
      
      //CartDAO cartDao = new CartDAO();
      //Cart cart = cartDao.getByUserId(user.getId());
      Cart cart = user.getCart();
      
      CartItemDAO ciDao = new CartItemDAO();
      CartItem cartItem = ciDao.get(cart.getCartid(),bookid);
      if(cartItem ==null){
        cartItem = new CartItem();
        cartItem.setBookid(Integer.parseInt(request.getParameter("bookid")));
        cartItem.setCart(cart);
        cartItem.setQuantity(0);
      }
      int i = cartItem.getQuantity()+1;
      cartItem.setQuantity(i);
      
      ciDao.create(cartItem);
      
      
      request.setAttribute("book", temp); 
      request.setAttribute("cart", cart);
      return new ModelAndView("details");   
      //   request.getSession().setAttribute("shopCart", books);
    }
    }
}
