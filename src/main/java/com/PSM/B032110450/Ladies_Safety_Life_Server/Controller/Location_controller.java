package com.PSM.B032110450.Ladies_Safety_Life_Server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Location;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Period;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.Location_repository;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Repository.Period_repository;

@RestController
@RequestMapping ("/api/Location")
public class Location_controller {

	@Autowired
	private Location_repository location_repository;
	
	@PostMapping()
	public Location insertlocation(@RequestBody Location location) {
		return location_repository.save(location);
	}
}

