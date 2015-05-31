<%@page import="Furniture.ProductDao"%>
<%@page import=".Product"%>
<%@page import="Furniture.ProductCatalog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Furniture.ProductCatalogDao"%>
<%@ page import="java.sql.*" %>

<%
    response.setHeader("Pragma", "No-cache");
    response.setDateHeader("Expires", 0);
    response.setHeader("Cache-Control", "no-cache");

    String path = request.getParameter("name");
 {
        try {
              out.println("<p>"
                    +"<img  src='"
                    +"myImg/"   + path + "'/>" + "</p>");

        } catch (Exception e) {
            out.println("Exception: <br>" + e);
        }
    }
     
%>