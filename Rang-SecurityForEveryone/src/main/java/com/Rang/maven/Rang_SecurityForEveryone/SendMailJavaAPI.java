package com.Rang.maven.Rang_SecurityForEveryone;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;


//For attatchments
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMultipart;
import javax.mail.Multipart;

public class SendMailJavaAPI {

//        public static void main(String[] args) throws Exception
//        {
//
//        String to= "msd20837@aol.com";
//        String from= "destroyingbigcorporate@gmail.com";
//        final String username = "destroyingbigcorporate@gmail.com";
//        final String password = "jduslfsmegehdiee";
//
//        
//        }
        public static void sendEmail(String to, String from, final String username, final String password, File file) throws UnsupportedEncodingException
        {
        	Properties props = new Properties();
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            String msgBody = "Motion has been detected on at least one of your security cameras. View the video file below to see the footage";

            try {
                Message msg = new MimeMessage(session);
                
                BodyPart attachment1 = new MimeBodyPart();
                attachment1.setDataHandler(new DataHandler(new FileDataSource(file)));
                attachment1.setFileName("INTRUDER ALERT.mp4");
                
                BodyPart emailText = new MimeBodyPart();
                emailText.setText(msgBody);
                
                Multipart multipartContent = new MimeMultipart();
                multipartContent.addBodyPart(attachment1);
                multipartContent.addBodyPart(emailText);
                
                msg.setFrom(new InternetAddress(from,"Rang Customer Service"));
                msg.addRecipient(Message.RecipientType.TO,
                                 new InternetAddress(to, "Valued Customer"));
                msg.setSubject("New Motion Detected on Cameras");
                msg.setText(msgBody);
                msg.setContent(multipartContent);
                
                Transport.send(msg);
                System.out.println("Email sent successfully...");

            } catch (AddressException e) {
                throw new RuntimeException(e);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
}