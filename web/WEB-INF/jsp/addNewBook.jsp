<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%-- 
    Document   : addNewBook
    Created on : Dec 4, 2012, 4:39:00 PM
    Author     : Sherry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <script type="text/javascript">
        
    </script>
</head>

            <div class="center_content">
                <div class="left_content">
                    <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" />New</span></div>

                    <div class="feat_prod_box_details">
                        <p class="details">
                            This page is for our bookstore admin use only.
                        </p>

                        <div class="contact_form">
                            <div class="form_subtitle">add new book</div>
                            <form:form commandName="book" method="post" enctype="multipart/form-data">         
                                <div class="form_row">
                                    <label class="contact"><strong>Name:</strong></label>
                                    <form:input type="text" class="contact_input" path="name" />
                                </div>

                                <div class="form_row">
                                    <label class="contact"><strong>Price:</strong></label>
                                    <form:input type="text" class="contact_input" path="price" />
                                </div> 

                                <div class="form_row">
                                    <label class="contact"><strong>Details:</strong></label>
                                    <form:input type="text" class="contact_input" path="descript" /> 
                                </div>

                                <div class="form_row">
                                    <label class="contact"><strong>More:</strong></label>
                                    <form:input type="text" class="contact_input" path="contents" /> 
                                </div>
                                <%--            
                                            <div class="form_row">
                                            <label class="contact"><strong>Company:</strong></label>
                                            <input type="text" class="contact_input" />
                                            </div>
                                            
                                            <div class="form_row">
                                            <label class="contact"><strong>Adrres:</strong></label>
                                            <input type="text" class="contact_input" />
                                            </div>                    
                                --%> 
                                <div class="form_row">
                                    <label class="contact"><strong>Option:</strong></label>
                                    &nbsp;&nbsp;
                                    <form:select path="typeid" class="contact_input">
                                        <form:option value="1">Normal</form:option>
                                        <form:option value="2">New</form:option>
                                        <form:option value="3">10% Off</form:option>
                                        <form:option value="4">Special</form:option> 
                                    </form:select>
                                </div>
                                
                                <div class="form_row">
                                    <label class="contact"><strong>Picture:</strong></label>
                                    <form:input type = "file" class = "contact_input" path="image" />
                                </div>


                                <div class="form_row">
                                    <div class="terms">
                                        <input type="checkbox" name="terms" />
                                        I agree to the <a href="#">terms &amp; conditions</a>                        </div>
                                </div> 

                                <div class="form_row">
                                    <font color="red"><form:errors path="name"/> </font>
                                </div>
                                <div class="form_row">
                                    <font color="red"><form:errors path="descript"/> </font>
                                </div>
                                <div class="form_row">
                                    <font color="red"><form:errors path="contents"/> </font>
                                </div>
                                
                                <div class="form_row">
                                    <input type="submit" class="register" value="Add" />
                                </div> 

                            </form:form>     
                        </div>  

                    </div>	




                    <div class="clear"></div>
                </div><!--end of left content-->

  


