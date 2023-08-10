package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import org.aspectj.weaver.ast.Test;
import org.hibernate.Length;
import org.hibernate.query.NativeQuery.ReturnableResultNode;
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
import com.PSM.B032110450.Ladies_Safety_Life_Server.Service.EmailService;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Service.EmailServiceImpl;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Service.JwtTools;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Service.Utils;



@RestController
@RequestMapping("/")

public class Public_rest_controller {

	
	@Autowired
	private User_repository user_Repository;
	//bru tmbh
	@Autowired
	private EmailService emailService;
	
	//part login utk dpt token
	
	//login part
	
	
	// login method
	//user parameter
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
	
//----asal first utk test----//
	/*@PostMapping("/reset")
	
	//function utk /reset password yg ambik dari user nurfathihahgazman@gmail.com
	//find by mail.. mail user yg nk reset tu dtg @RequestBody User user
	
	public ResponseEntity<?>reset(@RequestBody User user){
		
		//tarik dari set user_repo panggil daripd findbyemail.
		//set string newpassword=test utk replace obj resetUser simpan kt user repo
		
		User resetUser = user_Repository.findByEmail(user.getEmail());
		if(resetUser == null) {
			return ResponseEntity.badRequest().body("Invalid email");
		}
		//test new password
		 String newPassword = "test";
		 resetUser.setPassword(newPassword);
		 user_Repository.save(resetUser);
		 
		 //obj class nama EmailDetails pastu set resetUser
		 EmailDetails emailDetails = new EmailDetails();
		 //subj dia buh reset password
		 emailDetails.setRecipient(resetUser.getEmail());
		 emailDetails.setSubject("Password Reset");
		 
		 //msjbody set new password tp ambik yg +newpassword="test" 
		 emailDetails.setMsgBodyString("Your new password is: " + newPassword);
		
		 return ResponseEntity.ok().body("Password reset successful");
		 
	}*/
	
	// ---- yang baru utk reset password ----//
	
	
	
	@PostMapping("/reset")
	

	public ResponseEntity<?>reset(@RequestBody User user){
		
	 
		 
		
		User resetUser = user_Repository.findByEmail(user.getEmail());
		if(resetUser == null) {
			return ResponseEntity.badRequest().body("Invalid email");
		}
		
		 String newPassword = Utils.generateRandomString(15);
		 
		 resetUser.setPassword(newPassword);
		 user_Repository.save(resetUser);
		 
		
		 EmailDetails emailDetails = new EmailDetails();
		 
		 emailDetails.setRecipient(resetUser.getEmail());
		 emailDetails.setSubject("Password Reset");
		 emailDetails.setMsgBodyString("Your new password is: " + newPassword);
		
		 emailService.sendSimpleMail(emailDetails);
		 
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
	
	@GetMapping("/test")
	public String testLogin() {
		return "test"; 
	}
	
	//logout
	
	//@GetMapping("/logout")
	//public ResponseEntity<?> logout(){
		//HttpHeaders headers = new HttpHeaders();
		//headers.add(HttpHeaders.SET_COOKIE, "token = "; Max-age = 0; Path =/; HttpOnly");"
			//return ResponseEntity.ok().header(headers).body("logged out");	
	
}
