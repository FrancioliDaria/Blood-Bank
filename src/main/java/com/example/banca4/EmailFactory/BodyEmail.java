package com.example.banca4.EmailFactory;

   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.mail.MailSender;
   import org.springframework.mail.SimpleMailMessage;
   import org.springframework.stereotype.Service;

@Service
public class BodyEmail {

  private final MailSender mailSender;

  @Autowired
  public BodyEmail(MailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void sendEmail(String to, String subject, String body) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(body);
    mailSender.send(message);
  }
}
