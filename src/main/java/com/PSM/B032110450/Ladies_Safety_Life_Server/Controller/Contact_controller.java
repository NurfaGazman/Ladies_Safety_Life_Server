package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Contact;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.Contact_repository;

@RestController
@RequestMapping("/api/Contact")

public class Contact_controller {

	@Autowired
	private Contact_repository contact_repository;
	
	@PostMapping()
	public Contact insertContact (@RequestBody Contact contact) {
		return contact_repository.save(contact);
	}
}
