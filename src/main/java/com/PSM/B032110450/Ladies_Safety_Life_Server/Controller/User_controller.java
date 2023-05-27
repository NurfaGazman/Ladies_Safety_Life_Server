package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.User;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.User_repository;

@RestController
@RequestMapping("/api/User")

public class User_controller {

	@Autowired
	private User_repository user_repository;
	
	@PostMapping()
	public User insertuser(@RequestBody User user) {
		return user_repository.save(user);
	}
}
