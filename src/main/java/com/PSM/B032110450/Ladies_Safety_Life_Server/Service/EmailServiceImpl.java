package com.PSM.B032110450.Ladies_Safety_Life_Server.Service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired 
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}") private String sender;
	
	
	//method 1
	//to send a simple email
	
	@Override
	public String sendSimpleMail(EmailDetails details) {
		
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender); 
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBodyString());
			mailMessage.setSubject(details.getSubject());
			
			//Sending the mail
			javaMailSender.send(mailMessage);
			return  "Mail send Successfully" ;
								
		}
		
		//catch block to handle the expection
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Error while sending mail";
			
		}
	}
	
	//method 2
	//to send an email with attachment
	@Override
	
	public String sendMailWithAttachment(EmailDetails details) {
		// TODO Auto-generated method stub

		
		//creating a mime message
		jakarta.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		
		try {
			//setting multipart as true for attachments to
			//be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBodyString());
			mimeMessageHelper.setSubject(details.getSubject());
			
			// Adding the attachment
            FileSystemResource file
                = new FileSystemResource(
                    new File(details.getAttachment()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
		}
		//catch block to handle MessagingException
		catch(jakarta.mail.MessagingException e){
			//display message when exception occurred
			return "Error while sending mail!";
		}
		
	}
	
}
