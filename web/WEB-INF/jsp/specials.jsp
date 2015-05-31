<%-- 
    Document   : specials
    Created on : Dec 11, 2012, 3:48:01 PM
    Author     : Sherry
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

 <div class="center_content">
       	<div class="left_content">
        	
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Special gifts</div>
        
       <c:forEach var="item" items="${requestScope.books}">
            <div class="feat_prod_box">
            
            	<div class="prod_img"><a href="details.htm?id=${item.id}"><img src="${item.imagefile}" alt="" title="" border="0" /></a></div>
                
                <div class="prod_det_box">
                	<span class="special_icon"><img src="images/special_icon.gif" alt="" title="" /></span>
                	<div class="box_top"></div>
                    <div class="box_center">
                        
                    <div class="prod_title">${item.name}</div>
                    <p class="details">${item.descript}</p>
                    <a href="details.htm?id=${item.id}" class="more">- more details -</a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
              
        </c:forEach> 	
            
                 
            
        <div class="clear"></div>
        </div><!--end of left content-->

