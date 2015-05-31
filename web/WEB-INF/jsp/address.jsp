<%-- 
    Document   : manageAddress
    Created on : Dec 9, 2012, 3:12:55 PM
    Author     : Sherry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

       <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Manage AddressBook</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
            Current AddressBook:
            </p>
 
            
            <table class="cart_table">
                                <tr class="cart_title">
                                    <td>Address ID</td>
                                    <td>street1</td> 
                                    <td>street2</td> 
                                    <td>city</td>
                                    <td>state</td>
                                </tr>
                                <c:forEach var="item" items="${addList}">
                                    <tr>
                                        <td>${item.addressID}</td>
                                        <td>${item.street1}</td>
                                        <td>${item.street2}</td> 
                                        <td>${item.city}</td> 
                                        <td>${item.state}</td> 
                                    </tr>          
                                </c:forEach>
                

                            </table>

                                    <p></p>   
                                    <p></p>  
                                    <p></p>  
                                    <p></p>  
                                    <p>Or add New Address to your address book</p>  
            
              	<div class="contact_form">
                <div class="form_subtitle">create new address</div>
                <form:form commandName="address">         
                   
                    <div class="form_row">
                    <label class="contact"><strong>Street1:</strong></label>
                    <form:input type="text" class="contact_input" path="street1" />
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>Street2:</strong></label>
                    <form:input type="text" class="contact_input" path="street2"/>
                    </div> 

                    <div class="form_row">
                    <label class="contact"><strong>City:</strong></label>
                    <form:input type="text" class="contact_input" path="city"/>
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>State:</strong></label>
                    <form:input type="text" class="contact_input" path="state"/>
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>Zip:</strong></label>
                    <form:input type="text" class="contact_input" path="zip"/>
                    </div>
                                

                    
                    <div class="form_row">
                    <input type="submit" class="register" value="Add" />
                    </div>   
                  </form:form>     
                </div>  
            
          </div>
       <div class="clear"></div>
        </div>     
