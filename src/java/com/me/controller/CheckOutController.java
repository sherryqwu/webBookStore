/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.AddressDAO;
import com.me.DAO.CartDAO;
import com.me.DAO.OrderDAO;
import com.me.DAO.UserDAO;
import com.me.pojo.Address;
import com.me.pojo.Cart;
import com.me.pojo.Order;
import com.me.pojo.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Administrator
 */
public class CheckOutController extends AbstractController {

    public CheckOutController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
      
        if (user==null){
          request.setAttribute("errormessage","Illegal");
          return new ModelAndView("error");

      }


        Order order = new Order();
        order.setUserid(user.getId());
        order.setCartid(Integer.parseInt(request.getParameter("cartid")));


        if (order.getCart().getCount() < 1) {
            //request.setAttribute("errormessage","Your Cart is empty!");

            CartDAO cartDao = new CartDAO();
            //Cart cart = cartDao.getByUserId(user.getId());
            int temp = user.getCart().getCartid();
            Cart cart = cartDao.getByCartID(temp);

            AddressDAO addDao = new AddressDAO();
            ArrayList<Address> adds = addDao.getAllAddress(user.getId());
            //ArrayList<CartItem> items = user.getCart().getItems();
            request.setAttribute("adds", adds);
            request.setAttribute("cartError", "Your Cart is Empty!");
            return new ModelAndView("cart", "cart", cart);
            //  return new ModelAndView("redirect:cart.htm?cartError=Your+Cart+Is+Empty");
        }

        if (request.getParameter("add") == null) {
            CartDAO cartDao = new CartDAO();
            //Cart cart = cartDao.getByUserId(user.getId());
            int temp = user.getCart().getCartid();
            Cart cart = cartDao.getByCartID(temp);

            AddressDAO addDao = new AddressDAO();
            ArrayList<Address> adds = addDao.getAllAddress(user.getId());
            //ArrayList<CartItem> items = user.getCart().getItems();
            request.setAttribute("adds", adds);
            request.setAttribute("addError", "Your Address is Empty!");
            return new ModelAndView("cart", "cart", cart);
//          return new ModelAndView("error");
        }

        order.setAddressid(Integer.parseInt(request.getParameter("add")));
        OrderDAO orderDao = new OrderDAO();
        orderDao.saveOrder(order);

        Cart newCart = new Cart();
        newCart.setUserid(user.getId());
        CartDAO cartDao = new CartDAO();
        newCart = cartDao.create(newCart);
        user.setCart(newCart);
        cartDao.close();

        UserDAO userDao = new UserDAO();
        userDao.create(user);
        userDao.close();

        return new ModelAndView("checkout");
    }
}
