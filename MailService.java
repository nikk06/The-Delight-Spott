package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
@Service
public class MailService {
     @Autowired
	 private JavaMailSender javaMailSender;
	 
	 public String generateOtp()
		{
			Random random=new Random();
			int otp=100000+random.nextInt(900000);
			return String.valueOf(otp);
		}
	 
	 public void sendMail(Model1 model1, String otp)
	 {
		 try
		 {
			 String subject="HYE THIS OTP IS SEND FOR VERIFY YOUR EMAIL ID";
			 MimeMessage message=javaMailSender.createMimeMessage();
			 MimeMessageHelper helper=new MimeMessageHelper(message);
			 helper.setFrom("nitinsr246@gmail.com");
			 helper.setTo(model1.getVemail());
			 helper.setSubject(subject);
			 helper.setText("Your One Time Password is:"+"\t"+otp);
			 javaMailSender.send(message);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	 
	   public void sendMail1(Model3 model3, String otp)
	 {
		 try
		 {
			 String subject="HYE THIS OTP IS SEND FOR VERIFY YOUR EMAIL ID";
			 MimeMessage message=javaMailSender.createMimeMessage();
			 MimeMessageHelper helper=new MimeMessageHelper(message);
			 helper.setFrom("nitinsr246@gmail.com");
			 helper.setTo(model3.getCemail());
			 helper.setSubject(subject);
			 helper.setText("Your One Time Password is:"+"\t"+otp);
			 javaMailSender.send(message);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	  
}
