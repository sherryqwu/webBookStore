/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;


import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Administrator
 */
public class SendMail {

    /**
     * @param args the command line arguments
     */
    public static void sendMail(String email, String name,String subject,String mess) {


        final String username = "sherry.qwu@gmail.com";
        final String password = "sherry8823";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("wu.qio@husky.neu.edu"));
            message.setSubject("This is a message send from "+ name + "\n" + "Subject: " + subject);
            message.setText("Content: "+ mess +"\n" + "Contact he/she at: "+ email);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
