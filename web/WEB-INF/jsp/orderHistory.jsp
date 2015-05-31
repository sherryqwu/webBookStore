<%-- 
    Document   : cart
    Created on : Dec 6, 2012, 11:24:37 AM
    Author     : Sherry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


            <div class="center_content">
                <div class="left_content">
                    <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My Order History</div>

                    <div class="feat_prod_box_details">

                            <table class="cart_table">
                                <tr class="cart_title">
                                    <td>Order ID</td>
                                    <td>Item Amount</td> 
                                    <td>Total Price</td>
                                    <td>Detail PDF</td>
                                </tr>
                                <c:forEach var="order" items="${orderHistory}">
                                    <tr>
                                        <td><a href="orderDetail.htm?cartid=${order.cart.cartid}">${order.orderid}</a></td>
                                        <td>${order.cart.count}</td>
                                        <td>${order.cart.totalPrice}</td>
                                        <td><a href="pdf.htm?cartid=${order.cart.cartid}">Download</a></td>
                                    </tr>          
                                </c:forEach>

              

                            </table>

                    </div>	
                    <div class="clear"></div>
                </div><!--end of left content-->



