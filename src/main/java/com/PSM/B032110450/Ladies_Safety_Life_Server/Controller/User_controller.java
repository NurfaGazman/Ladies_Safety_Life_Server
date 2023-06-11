package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import java.util.Optional;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.User;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.User_repository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/User")

public class User_controller {

	
	@Autowired
	private User_repository user_repository;
	
	
	@GetMapping
	public User getUser(HttpServletRequest request) {
			long userId = Integer.parseInt(request.getAttribute("user_Id").toString()); 		
		return  user_repository.findById(userId).get();
	}
	
	@PutMapping
	public ResponseEntity<User> upUser(HttpServletRequest request, @RequestBody User user) {
			
			long userId = Integer.parseInt(request.getAttribute("user_Id").toString()); 
			
			Optional<User> updateUser = user_repository.findById(userId);
			
			if(updateUser.isEmpty())
				return ResponseEntity.notFound().build();
				User objUser = new User();
				objUser = updateUser.get();
				
			if(user.getFull_name()!= null)
				objUser.setFull_name(user.getFull_name());
			
			if(user.getAddress()!= null)
				objUser.setAddress(user.getAddress());
			
			if(user.getBlood_gp()!= null)
				objUser.setBlood_gp(user.getBlood_gp());
			
			if(user.getMedical_Id()!= null)
				objUser.setMedical_Id(user.getMedical_Id());
			
			if(user.getBirth_date()!= null)
				objUser.setBirth_date(user.getBirth_date());
			
			
			return ResponseEntity.ok(user_repository.save(objUser));
			
	}
	
}
