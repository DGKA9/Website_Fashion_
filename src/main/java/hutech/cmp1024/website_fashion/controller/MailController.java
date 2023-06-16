package hutech.cmp1024.website_fashion.controller;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MailController {
    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public String sendMail(){

        return "contact/mail";
    }
    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public String sendMail(@RequestParam("phone") String phone,
                           @RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam("title") String title,
                           @RequestParam("content") String content) {

        int port = 587;
        String username = "louree1802@gmail.com";
        String password = "uhqeqqbblbxplidi";
        String host = "smtp.gmail.com";
        String from = "louree1802@gmail.com";
        String to = "nvdqb73@gmail.com";

        // Set SMTP server properties
        java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Create an authenticator instance to authenticate the username and password
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Get the default Session object with the provided authenticator
        Session session = Session.getInstance(properties, authenticator);

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(from));

            // Set To: header field
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(title);

            // Set the actual message
            String mailContent = "Name: " + name + "\n"
                    + "Phone: " + phone + "\n"
                    + "Email: " + email + "\n\n"
                    + content;
            message.setText(mailContent);

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully.");
            return "contact/mail"; // Return the desired view after sending the email
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return "error"; // Return an error view if email sending fails
        }
    }
}
