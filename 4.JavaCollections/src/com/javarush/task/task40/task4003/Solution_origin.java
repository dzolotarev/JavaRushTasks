//package com.javarush.task.task40.task4003;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
///*
//Отправка письма с файлом
//https://mvnrepository.com/artifact/javax.mail/javax.mail-api/1.6.2
//https://mvnrepository.com/artifact/com.sun.mail/javax.mail/1.5.1
//https://mvnrepository.com/artifact/javax.activation/activation/1.1.1
//*/
//
//public class Solution_origin {
//
//    public static void main(String[] args) {
//        Solution_origin solution = new Solution_origin();
//        solution.sendMail("name.lastname@gmail.com", "password", "friend@gmail.com");
//    }
//
//    public void sendMail(final String username, final String password, final String recipients) {
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//                new Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
//
//            setSubject(message, "Тестовое письмо");
//            setAttachment(message, "c:/text.txt");
//
//            Transport.send(message);
//            System.out.println("Письмо было отправлено.");
//
//        } catch (MessagingException e) {
//            System.out.println("Ошибка при отправке: " + e.toString());
//        }
//    }
//
//    public static void setSubject(Message message, String subject) throws MessagingException {
//        message.setSubject(subject);
//    }
//
//    public static void setAttachment(Message message, String filename) throws MessagingException {
//        message.setText(filename);
//    }
//}