<%-- 
    Document   : cart
    Created on : Dec 6, 2012, 11:24:37 AM
    Author     : Sherry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="ajax\selectmessage.js" type="text/javascript">    
</script>

<div class="center_content">
    <div class="left_content">
        <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My cart</div>

        <form action="checkout.htm">

            <div class="feat_prod_box_details">
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
                            <td>
                                <select name="${item.itemid}" onchange="WQupdate(this.name,this.value)">
                                    <c:forEach begin="0" end="${item.quantity+2}" var="i">
                                        <c:if test="${i!=item.quantity}">
                                            <option value="${i}">${i}</option>
                                        </c:if>
                                        <c:if test="${i==item.quantity}">
                                            <option value="${i}" selected>${i}</option>
                                        </c:if>
                                    </c:forEach>

                                </select>
                            </td>       
                            <td>${item.quantity * item.book.price}$</td>               
                        </tr>          
                    </c:forEach>





                    <tr>
                        <td colspan="4" class="cart_total"><span class="red">TOTAL:</span></td>
                        <td> ${cart.totalPrice}</td>                
                    </tr>                  

                </table>
                    <font color="red">${cartError}</font>
            </div>	
            
            

            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My Addresses Book</div>
            <div class="feat_prod_box_details">
                <p class="details">
                    Current AddressBook:
                </p>


                <table class="cart_table">
                    <tr class="cart_title">
                        <td>&nbsp;</td>
                        <td>street1</td> 
                        <td>street2</td> 
                        <td>city</td>
                        <td>state</td>
                    </tr>
                    <c:forEach var="add" items="${adds}">
                        <tr>
                            <td><input type="radio" name="add" value="${add.addressID}" /></td>
                            <td>${add.street1}</td>
                            <td>${add.street2}</td> 
                            <td>${add.city}</td> 
                            <td>${add.state}</td> 
                        </tr>          
                    </c:forEach>


                </table>
                <font color="red">${addError}</font><br/>
            </div>
            
            <div class="form_row">

            <input type="hidden" name="cartid" value="${sessionScope.user.cart.cartid}"/>
            <input type="submit" class="register" value="Check out"/>
            </div>
        </form>

    <div class="clear"></div>
</div><!--end of left content-->



