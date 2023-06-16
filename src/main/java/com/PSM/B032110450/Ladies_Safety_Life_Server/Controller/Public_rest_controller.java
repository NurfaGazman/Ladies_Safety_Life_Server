package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.EmailDetails;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.User;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.User_repository;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Service.JwtTools;

import jakarta.validation.constraints.Email;

@RestController
@RequestMapping("/")

public class Public_rest_controller {

	
	@Autowired
	private User_repository user_Repository;
	
	//part login utk dpt token
	
	//login part
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login (@RequestBody User user){
		User loginUser = user_Repository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		
		if(loginUser == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("bad credential");
		}
		else { 
			return ResponseEntity.ok().body(JwtTools.generateToken( Integer.toString(loginUser.getUser_Id()) , loginUser.getEmail(), loginUser.getFull_name()));
		}
	}
	
	//reset email first try
	
	/*@PostMapping("/reset")
	public ResponseEntity<?> reset (@RequestBody User user){
		User resetUser = user_Repository.findbyEmail(user.getEmail());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("");
	
	}*/
	
	
	//reset password for(forgot password) 
	
	@PostMapping("/reset")
	public ResponseEntity<?>reset(@RequestBody User user){
		User resetUser = user_Repository.findbyEmail(user.getEmail());
		if(resetUser == null) {
			return ResponseEntity.badRequest().body("Invalid email");
		}
		
		 String newPassword = "test";
		 resetUser.setPassword(newPassword);
		 user_Repository.save(resetUser);
		 
		 EmailDetails emailDetails = new EmailDetails();
		 
		emailDetails.setRecipient(resetUser.getEmail());
		emailDetails.setSubject("Password Reset");
		emailDetails.setMsgBodyString("Your new password is: " + newPassword);
		
		 return ResponseEntity.ok().body("Password reset successful");
		 
	}
	
	
		
	@GetMapping("/api/verify")
	public ResponseEntity<?> testToken(){
		return ResponseEntity.ok().body("");
	}
	
	//register part 
	
	@PostMapping("/register")
	public User insertuser(@RequestBody User user) {
		System.out.println("Test");
		return user_Repository.save(user);
	}
	
	//logout
	
	//@GetMapping("/logout")
	//public ResponseEntity<?> logout(){
		//HttpHeaders headers = new HttpHeaders();
		//headers.add(HttpHeaders.SET_COOKIE, "token = "; Max-age = 0; Path =/; HttpOnly");"
			//return ResponseEntity.ok().header(headers).body("logged out");	
	
}
