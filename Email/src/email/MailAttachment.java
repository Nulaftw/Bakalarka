package email;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

// TLS verze
public class MailAttachment {

    public static void main(String[] args) {

        String filePath = "D:/test.txt";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

       Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("nulaftw@gmail.com","bassgeige");
				}
			});

        try {

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("nulaftw@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("gromzero@gmail.com"));
            msg.setSentDate(new Date());
            msg.setSubject("pokus");

            String text = "Priloha?";

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(text, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            MimeBodyPart attachPart = new MimeBodyPart();
            try {
                attachPart.attachFile(filePath);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            multipart.addBodyPart(attachPart);
            msg.setContent(multipart);

            Transport.send(msg);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
