package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Contact;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Contact_Id;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Location;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.Contact_repository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import jakarta.security.auth.message.callback.SecretKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/Contact")

public class Contact_controller {

	@Autowired
	private Contact_repository contact_repository;
	
	@PostMapping()
	public Contact insertContact (HttpServletRequest request, @RequestBody Contact contact) {
		int userId = Integer.parseInt(request.getAttribute("user_Id").toString());
		contact.setUserId(userId);
		return contact_repository.save(contact);
	}
	
	
	@GetMapping
	public List<Contact> getcontaContact(HttpServletRequest request) {
		long userId = Integer.parseInt(request.getAttribute("user_Id").toString()); 
		return  contact_repository.findAllByuserId((int)userId);
		
	}
	
	@DeleteMapping("{contact_no}")
	public ResponseEntity<HttpStatus> deleteContact(HttpServletRequest request ,@PathVariable String contact_no){
		int userId = Integer.parseInt(request.getAttribute("user_Id").toString());
		
		Contact_Id id = new Contact_Id();
		id.setContact_no(contact_no);
		id.setUserId(userId);
		contact_repository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/emergency")
	public ResponseEntity<HttpStatus> emergencyAPI(HttpServletRequest request, @RequestBody Location location){
		//long userId = Integer.parseInt(request.getAttribute("user_Id").toString()); 
		//List<Contact> getContacts = contact_repository.findAllByuserId((int)userId);
		//for(Contact contact:getContacts) {
			//Whatsapp_controller.sendMessage(contact.getContact_no(),"try send");	
		//}
		
	
		
		Twilio.init("AC5ac0d75557d2b8dd97d2df206a2f0fcf", "f14d1cf448d495d76621f180cc45ad5a");
		Message message = Message.creator(
				new com.twilio.type.PhoneNumber("whatsapp:+601133037857"),
				new com.twilio.type.PhoneNumber("whatsapp:14155238886"),
				"message").create();
				
				System.out.println(message.getSid());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}

