/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author luizm
 */
public class MailSender {
    private String host = "mail.savioliti.com.br",
                   port = "587",
                   myEmail = "aulajava@savioliti.com.br",
                   myPass = "@1b2c3d4e5";
    
    public void sendKeyMail(String mailTo, String key) throws AddressException, MessagingException{
        Properties props = new Properties();
        
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "mail.savioliti.com.br");
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, myPass);
            }
        });
        
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(myEmail));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
        msg.setSubject("Use o código para entrar no sistema");
        msg.setText("Foi reconhecida uma tentiva de login para acessar o sistema com o email: "+mailTo+ "\n" +
                    "Para entrar utilize o código a seguir: "+key+ "\n" +
                    "Caso a tentativa de login não seja sua, considere modificar sua senha!");
        Transport.send(msg);
    }
    
}
