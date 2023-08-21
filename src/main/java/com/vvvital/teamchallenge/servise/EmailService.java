package com.vvvital.teamchallenge.servise;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    @Autowired
    public JavaMailSender mailSender;


    public void sendMail(String toAddress,String subject, String massage){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(massage);
        mailSender.send(simpleMailMessage);
    }

    public static String codeGenerator(){
        String code = "";
        for (int i = 0; i < 16; i++) {
            char c = (char) (Math.random()*79+47);
            code=code.concat(String.valueOf(c));
        }
        return code;
    }
}
