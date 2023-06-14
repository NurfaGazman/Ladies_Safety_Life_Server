package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.EmailDetails;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Service.EmailService;

//Annotation
public class EmailController  {
	@Autowired
	private EmailService emailService;
	
	//sending a simple email
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {
		String status = emailService.sendSimpleMail(details);
		return status;
		
		
	}
	
	// Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
        @RequestBody EmailDetails details)
    {
        String status= emailService.sendMailWithAttachment(details);
        return status;
    }
	
}
