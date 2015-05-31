<%-- 
    Document   : contact
    Created on : Dec 12, 2012, 7:12:26 AM
    Author     : Sherry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="center_content">
    <div class="left_content">
        <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Contact us</div>

        <div class="feat_prod_box_details">
            <p class="details">
                Welcome to email us any advice and suggestion
            </p>

            <form action="contactDetail.htm">
                <div class="contact_form">
                    <div class="form_subtitle">Send us message</div>

                    <div class="form_row">
                        <label class="contact"><strong>Name:</strong></label>
                        <input type="text" class="contact_input" name="name" />
                    </div>  


                    <div class="form_row">
                        <label class="contact"><strong>Email:</strong></label>
                        <input type="text" class="contact_input" name="email"/>
                    </div> 



                    <div class="form_row">
                        <label class="contact"><strong>Subject:</strong></label>
                        <input type="text" class="contact_input" name="subject"/>
                    </div>

                    <div class="form_row">
                        <label class="contact"><strong>Message:</strong></label>
                        <textarea class="contact_textarea" name="message"></textarea>


                        <div class="form_row">
                            <input type="submit" value="send" class="register"/>
                        </div>
                    </div>  
                </div>  
            </form>
        </div>	






        <div class="clear"></div>
    </div><!--end of left content-->