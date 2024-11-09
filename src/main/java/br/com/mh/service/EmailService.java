package br.com.mh.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.mh.entity.Email;
import br.com.mh.entity.StatusEmail;
import br.com.mh.repository.EmailRepository;

@Service
public class EmailService {
    @Autowired
    //Depois colocar por construtor
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @SuppressWarnings("finally")
    public Email sendEmail(Email email){
        //Setar data de envio
      email.setEmaildataEnvio(LocalDateTime.now());
    try {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(email.getEmailFrom());
        message.setTo(email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setText(message.getText());

        emailSender.send(message);

        email.setStatusEmail(StatusEmail.ENVIADO);
        
      } catch (MailException e) {
        email.setStatusEmail(StatusEmail.ERROR);
      }finally{
        return emailRepository.save(email);
      }
      //Metodo teste para envio de email predefinido

      //Tentativa de teste

      /* 
      Email email2= new Email();
      email2.setEmailTo("aline.sts.contato@gmail.com");
      email2.setSubject("Teste notificação");
      email2.setText("Esse é um email de teste checando sua consulta");

      //Enviando
      sendEmail(email);
      System.out.println("Email de teste enviado com sucesso!");
      return email2;
      */
      
    }


}
