package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Period;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.User;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.Period_repository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/Period")
public class Period_Controller {

	@Autowired
	private Period_repository period_repository;
	

	@PostMapping()
	public Period insertperiod(HttpServletRequest request,  @RequestBody Period period) {
		
		int userId = Integer.parseInt( request.getAttribute("user_Id").toString());
		
		period.setUser_Id(userId);
		return period_repository.save(period);

	}
	
	@GetMapping()
	public List<Period> getPeriod(HttpServletRequest request) {	
		long userId = Integer.parseInt(request.getAttribute("user_Id").toString()); 
		return  period_repository.userPeriods(userId);
	}	
	
   
	@PutMapping
	public Period updatePeriod(@RequestBody Period period) {
		return period_repository.save(period);
	}
	
	
	@DeleteMapping("{period_id}")
	public ResponseEntity<HttpStatus> deletePeriod(@PathVariable Long period_id){
		period_repository.deleteById(period_id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}


