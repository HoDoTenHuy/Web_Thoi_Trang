package com.danghuy.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class SendMail {

    public void sendMailToClient(String mailClient) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        MailSender mailSender = (MailSender) context.getBean("mailSender2");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dangngai.kz@gmail.com");
        message.setTo(mailClient);
        message.setSubject("MiniShop");
        message.setText("Don Hang Cua Ban Da Duoc Duyet, Nhan Vien Giao Hang Se Giao Den Ban Som Nhat!");
        mailSender.send(message);
        context.close();
    }
}
