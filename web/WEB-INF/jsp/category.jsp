<%-- 
    Document   : category
    Created on : Dec 4, 2012, 3:58:22 PM
    Author     : Sherry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
       
       
       <div class="center_content">
       	<div class="left_content">
        	<div class="crumb_nav">
            <a href="index.htm">home</a> &gt;&gt; books
            </div>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Category books</div>
           
           <div class="new_products">
               
               <c:forEach var="item" items="${requestScope.books}">
                    <div class="new_prod_box">
                        <a href="details.htm?id=${item.id}">${item.name}</a>
                        <div class="new_prod_bg">
                            <c:if test="${item.typeid == 2}">
                            <span class="new_icon"><img src="images/new_icon.gif" alt="" title="" /></span>
                            </c:if>
                            <c:if test="${item.typeid == 3}">
                            <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>
                            </c:if>
                        <a href="details.htm?id=${item.id}"><img src="${item.imagefile}" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
               </c:forEach>  
              
            
            </div> 
          
            
        <div class="clear"></div>
        </div><!--end of left content-->
    