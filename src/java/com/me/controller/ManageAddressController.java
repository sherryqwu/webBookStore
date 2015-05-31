/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.AddressDAO;
import com.me.pojo.Address;
import com.me.pojo.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Sherry
 */
public class ManageAddressController extends SimpleFormController {
    
    public ManageAddressController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
//    @Override
//    protected void doSubmitAction(Object command) throws Exception {
// //        
//       
//    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
     @Override
     protected ModelAndView onSubmit(
     HttpServletRequest request, 
     HttpServletResponse response, 
     Object command, 
     BindException errors) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        
        Address address = (Address) command;
        address.setUserID(user.getId());
        AddressDAO addressDao = new AddressDAO();
        addressDao.create(address); 
   //  ModelAndView mv = new ModelAndView(getSuccessView());
        ArrayList<Address> addList = addressDao.getAllAddress(user.getId());
        Address address1 = new Address();
        request.setAttribute("address", address1);
        ModelAndView mv = new ModelAndView(getSuccessView(), "addList", addList);
     //Do something...
        return mv;
     }
/*     
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        User user = (User) request.getSession().getAttribute("user");

        
        AddressDAO addressDao = new AddressDAO();
        ArrayList<Address> addList = addressDao.getAllAddress(user.getId());
        request.setAttribute("addList", addList);
        return new Address();
    }
    * */
    
    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
      User user = (User) request.getSession().getAttribute("user");
      if (user==null){
          request.setAttribute("errormessage","You have not <a href='myaccount.htm'>loged in</a>");
          return new ModelAndView("error");
      }
      
        AddressDAO addressDao = new AddressDAO();
        ArrayList<Address> addList = addressDao.getAllAddress(user.getId());
        request.setAttribute("addList", addList);
        
      return new ModelAndView(getFormView(),getCommandName(),new Address());
    }
}
    

