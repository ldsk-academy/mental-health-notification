package br.com.mh.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mh.dto.EmailDto;
import br.com.mh.entity.Email;
import br.com.mh.service.EmailService;
import jakarta.validation.Valid;

@RestController
public class EmailController {
    
    @Autowired
    EmailService emailService;

    //Criação de metodo
  @PostMapping("/envio-email")
  public ResponseEntity<Email>sendingEmail(@RequestBody @Valid EmailDto emailDto){
    Email email=new Email();
    BeanUtils.copyProperties(emailDto, email);
    emailService.sendEmail(email);
    return new ResponseEntity<>(email, HttpStatus.CREATED);

  }
}
