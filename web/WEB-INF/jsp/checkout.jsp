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
                    <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My cart</div>

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
                                <c:forEach var="item" items="${items}">
                                    <tr>
                                        <td><a href="details.htm"><img src="images/cart_thumb.gif" alt="" title="" border="0" class="cart_thumb" /></a></td>
                                        <td>${item.book.name}</td>
                                        <td>${item.book.price}$</td>
                                        <td>
                                            <select name="${item.itemid}" onchange="WQupdate(this.name,this.value)">
                                                <c:forEach begin="0" end="${item.quantity}" var="i">
                                                    <option value="${i}">${i}</option>
                                                </c:forEach>
                                                    <option value="${item.quantity}" selected>${item.quantity}</option>
                                            </select>
                                        </td>       
                                        <td>${item.quantity * item.book.price}$</td>               
                                    </tr>          
                                </c:forEach>
           

                            </table>
                         
                        </form>

                        <a href="checkout.htm?cartid=${sessionScope.user.cart.cartid}" class="checkout">checkout &gt;</a>




                    </div>	






                    <div class="clear"></div>
                </div><!--end of left content-->


