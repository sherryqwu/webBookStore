<%-- 
    Document   : orderHistoryDetail
    Created on : Dec 9, 2012, 8:07:25 PM
    Author     : Sherry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


            <div class="center_content">
                <div class="left_content">
                    <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Order History Detail</div>

                    <div class="feat_prod_box_details">
                        <form>
                            <table class="cart_table">
                                <tr class="cart_title">
                                    <td>Item pic</td>
                                    <td>Book name</td>
                                    <td>Unit price</td>
                                    <td>Qty</td>
                                    <td>Total</td>               
                                </tr>
                                <c:forEach var="item" items="${cart.items}">
                                    <tr>
                                        <td><a href="details.htm"><img src="images/cart_thumb.gif" alt="" title="" border="0" class="cart_thumb" /></a></td>
                                        <td>${item.book.name}</td>
                                        <td>${item.book.price}$</td>
                                        <td>${item.quantity} </td>       
                                        <td>${item.quantity * item.book.price}$</td>               
                                    </tr>          
                                </c:forEach>



                                <tr>
                                    <td colspan="4" class="cart_total"><span class="red">TOTAL:</span></td>
                                    <td> ${cart.totalPrice}</td>                
                                </tr>                  

                            </table>
                         
                        </form>

                        


                    </div>	






                    <div class="clear"></div>
                </div><!--end of left content-->

