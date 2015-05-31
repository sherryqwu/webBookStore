/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;


import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.me.DAO.AddressDAO;
import com.me.DAO.CartDAO;
import com.me.DAO.OrderDAO;
import com.me.DAO.UserDAO;
import com.me.pojo.Address;
import com.me.pojo.Cart;
import com.me.pojo.CartItem;
import com.me.pojo.Order;
import com.me.pojo.User;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author Administrator
 */
public class PDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, com.lowagie.text.Document dcmnt, com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        User user = (User) hsr.getSession().getAttribute("user");
        OrderDAO orderDao = new OrderDAO();
        ArrayList<Order> orders = orderDao.getOrderHistory(user.getId());
        int cartid = Integer.parseInt(hsr.getParameter("cartid")); 
        Order temp = new Order();
        for(Order order : orders) {
            if(order.getCartid()== cartid){
                temp = order;
            }
        }
        AddressDAO addressDao = new AddressDAO();
        
        Address address = addressDao.get(String.valueOf(temp.getAddressid()));
        
        
        CartDAO cartDao = new CartDAO();
        Cart cart = cartDao.getByCartID(cartid);


       dcmnt.add(new Paragraph("Order Detail", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD)));
       dcmnt.add(new Paragraph("\n\n"));
       dcmnt.add(new Paragraph("User Name:" + user.getUserName(), FontFactory.getFont(FontFactory.HELVETICA, 14)));
       dcmnt.add(new Paragraph("\n"));
        Font normal = FontFactory.getFont(FontFactory.HELVETICA, 14);

       dcmnt.add(new Paragraph("Shipping Address:" ,normal));
       dcmnt.add(new Paragraph("Line 1:" + address.getStreet1(), normal));
       dcmnt.add(new Paragraph("Line 2:" +address.getStreet2(), normal));
       dcmnt.add(new Paragraph("City:" +address.getCity()+"   " +"State:"+address.getState()+"   "+ address.getZip() , normal));
       
       
        
            
           
        //    dcmnt.add(new Paragraph("Total Sale:" + order.getTotalSale(), normal));
            
            PdfPTable t = new PdfPTable(4);

                t.setSpacingBefore(25);

                t.setSpacingAfter(25);

                PdfPCell c1 = new PdfPCell(new Phrase("Book Name"));

                t.addCell(c1);

                PdfPCell c2 = new PdfPCell(new Phrase("Unite Price"));

                t.addCell(c2);

                PdfPCell c3 = new PdfPCell(new Phrase("Quantity"));

                t.addCell(c3);
                
                PdfPCell c4 = new PdfPCell(new Phrase("Total"));

                t.addCell(c4);
                
            for (CartItem ci : cart.getItems()) {                      

                t.addCell(ci.getBook().getName());

                t.addCell(String.valueOf(ci.getBook().getPrice()));

                t.addCell(String.valueOf(ci.getQuantity()));
                
                t.addCell(String.valueOf(ci.getQuantity() * ci.getBook().getPrice()));
            }
            t.addCell(new PdfPCell(new Phrase(" ")));
            t.addCell(new PdfPCell(new Phrase(" ")));
            t.addCell(new PdfPCell(new Phrase(" ")));
            t.addCell(String.valueOf(cart.getTotalPrice()));
            
            dcmnt.add(t);
            
           // dcmnt.add(new Paragraph("Order Total: " + cart.getTotalPrice(), FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD)));
        }
    
   
    }


