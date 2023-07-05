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
import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.User;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.Contact_repository;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.Location_repository;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.User_repository;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Service.WhatsappService;

import jakarta.security.auth.message.callback.SecretKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/Contact")

public class Contact_controller {

	@Autowired
	private Contact_repository contact_repository;
	
	@Autowired
	private Location_repository location_repository;
	
	@Autowired
	private User_repository user_repository;
	
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
		Long userId = Long.valueOf(request.getAttribute("user_Id").toString()); 
		User user = user_repository.findById(userId).get();
		location.setUser_Id(userId.intValue());
		System.out.println(location.getLatitude()+" "+location.getLongitude());
		
		location_repository.save(location);
		String msg = " EMERGENCY LOCATION FROM " + user.getFull_name()
		+"\n https://www.google.com/maps/search/?api=1&query="+location.getLatitude()+","+location.getLongitude();
		System.out.println(msg);
		List<Contact> getContacts = contact_repository.findAllByuserId(userId.intValue());
		System.out.println(getContacts.size());
		for(Contact contact:getContacts) {
			System.out.println(contact.getContact_no());
			WhatsappService.send(contact.getContact_no(),msg);	
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}

