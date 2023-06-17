package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.EmailDetails;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Service.EmailService;

@RestController
@RequestMapping("/test")

public class EmailController {
	@Autowired
	  private EmailService emailService;

	
	  
	  @PostMapping
	  public String sendMail() {
	  EmailDetails emailDetails = new EmailDetails();
	  	  emailDetails.setRecipient("nurfathihahgazman@gmail.com");
	  	  emailDetails.setMsgBodyString("Test sampai jadi");
	  	  emailDetails.setSubject("KASI JADI");
	  	  
	  	  String emailSendString = emailService.sendSimpleMail(emailDetails);	  
	  	  //EmailController.sendSimpleMail(emailDetails);
	  	  
	  	  return emailSendString;
	  	  
	  }
	  
	  
	  // Sending email with attachment
	    //@PostMapping("/api/sendMailWithAttachment")
	    //public String sendMailWithAttachment(
	        //@RequestBody EmailDetails details)
	    //{
	       // String status= emailService.sendMailWithAttachment(details);
	        //return status;
	    //}
	  
	 
	  
		
	
}
