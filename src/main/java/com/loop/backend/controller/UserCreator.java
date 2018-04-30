package com.loop.backend.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.loop.backend.dto.UserInfo;
import com.loop.backend.pojo.person;
import com.loop.backend.repo.HotelRepo;

@RestController
@RequestMapping("/createuser")
public class UserCreator {
	
	@Autowired
	private HotelRepo repo;
	
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody UserInfo user) {
		
		if (user.getEmail().isEmpty() || user.getPassword().isEmpty() || user.getName().isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		person xx = new person(user.getEmail(), user.getPassword(), user.getName(), user.getPhonenumber());
		
	    person result = (person) repo.save(xx);
		

	    if (result.getId() > 0) {
	    	URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/createuser")
						.buildAndExpand(result.getId()).toUri();

	    	return ResponseEntity.created(location).build();
	    } else 
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();

	}


}
