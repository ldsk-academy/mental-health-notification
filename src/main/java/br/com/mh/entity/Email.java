package br.com.mh.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Tb_email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emailId;
    private String emailFrom;
    private String emailTo;
    private String subject;
    //Para não se limitar n° de caractere
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime emaildataEnvio;

   private StatusEmail statusEmail;

}

