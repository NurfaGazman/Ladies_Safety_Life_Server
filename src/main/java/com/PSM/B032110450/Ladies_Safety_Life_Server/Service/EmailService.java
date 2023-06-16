package com.PSM.B032110450.Ladies_Safety_Life_Server.Service;

import org.springframework.stereotype.Service;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.EmailDetails;


public interface EmailService {
	//Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
    
}
