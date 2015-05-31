<%@page import="com.me.DAO.CartDAO"%>
<%@page import="com.me.pojo.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.me.DAO.CartItemDAO"%>
<%@page import="com.me.pojo.User"%>
<%@ page import="java.sql.*" %>

<%
	response.setHeader("Pragma", "No-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-cache");
	
	Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
	
	String itemId = request.getParameter("name");
	String itemValue = request.getParameter("value");
    try
	{
		
            CartItemDAO ciDao = new CartItemDAO();
            CartItem tempItem = ciDao.get(itemId);
            tempItem.setQuantity(Integer.parseInt(itemValue));
            ciDao.update(tempItem);
            
            
	}
	catch(Exception e)
	{
		out.println("Exception: <br>" + e);
	}
%>