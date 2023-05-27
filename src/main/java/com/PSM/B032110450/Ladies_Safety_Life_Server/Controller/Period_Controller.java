package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Period;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.User;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.Period_repository;

@RestController
@RequestMapping("/api/Period")
public class Period_Controller {

	@Autowired
	private Period_repository period_repository;
	

	@PostMapping()
	public Period insertperiod(@RequestBody Period period) {
		return period_repository.save(period);
	
	}
}
