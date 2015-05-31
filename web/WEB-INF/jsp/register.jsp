<%-- 
    Document   : register
    Created on : Dec 4, 2012, 7:57:02 PM
    Author     : Sherry
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">



<div class="center_content">
    <div class="left_content">
        <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Register</div>

        <div class="feat_prod_box_details">
            <p class="details">
                Welcome to register to Sherry's bookstore
            </p>

            <div class="contact_form">
                <div class="form_subtitle">create new account</div>
                <form:form commandName="user">         

                    <div class="form_row">
                        <label class="contact"><strong>Username:</strong></label>
                        <form:input type="text" class="contact_input" path="userName" />
                    </div>  


                    <div class="form_row">
                        <label class="contact"><strong>Password:</strong></label>
                        <form:input type="password" class="contact_input" path="passWord"/>
                    </div> 

                    <div class="form_row">
                        <label class="contact"><strong>Email:</strong></label>
                        <form:input type="text" class="contact_input" path="Email"/>
                    </div>


                    <div class="form_row">
                        <label class="contact"><strong>Phone:</strong></label>
                        <form:input type="text" class="contact_input" path="phone"/>
                    </div>


                    <div class="form_row">
                        <font color="red"><form:errors path="userName"/> </font>
                    </div>
                    
                    <div class="form_row">
                        <font color="red"><form:errors path="passWord"/> </font>
                    </div>

                    <div class="form_row">
                        <input type="submit" class="register" value="register" />
                    </div>   
                </form:form>     
            </div>  

        </div>	






        <div class="clear"></div>
    </div><!--end of left content-->
