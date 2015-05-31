<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Book Store</title>
        <link rel="stylesheet" type="text/css" href="style.css" />

    </head>
    <body>
        <div id="wrap">

            <div class="header">
                <div class="logo">
                    <a href="index.htm"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>            


                <c:if test="${sessionScope.user.identity==0}">
                    <div id="menu">
                        <ul>                                                                       
                            <li class="selected"><a href="index.htm">home</a></li>
                            <li><a href="category.htm">books</a></li>
                            <li><a href="specials.htm">specials</a></li>
                            <li><a href="myaccount.htm">Admin</a></li> 
                            <li><a href="addBook.htm">add book</a></li>
                            <li><a href="logout.htm">log out</a></li>
                        </ul>
                    </div>
                </c:if> 

                <c:if test="${empty sessionScope.user}">
                    <div id="menu">
                        <ul>                                                                       
                            <li class="selected"><a href="index.htm">home</a></li>
                            <li><a href="category.htm">books</a></li>
                            <li><a href="specials.htm">specials</a></li>
                            <li><a href="register.htm">register</a></li>
                            <li><a href="myaccount.htm">my account</a></li>
                            <li><a href="contact.htm">contact</a></li>
                        </ul>
                    </div>
                </c:if> 

                <c:if test="${sessionScope.user.identity==1}">
                    <div id="menu">
                        <ul>                                                                       
                            <li class="selected"><a href="index.htm">home</a></li>
                            <li><a href="category.htm">books</a></li>
                            <li><a href="specials.htm">specials</a></li>
                            <li><a href="myaccount.htm">login as ${sessionScope.user.userName}</a></li>
                            <li><a href="manageAdd.htm">addressbook manage</a></li>
                            <li><a href="contact.htm">contact</a></li>
                            <li><a href="logout.htm">log out</a></li>

                        </ul>
                    </div>
                </c:if>


            </div> 



