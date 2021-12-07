package com.cinema.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.Hall;
import com.cinema.test.service.HallService;

@RestController
@RequestMapping("/hall")
public class HallController {
	@Autowired
	HallService hallServ;
	
	@PostMapping("/createHall")
	public ResponseEntity<ResponseRegDTO> createHall(@RequestBody Hall hall ){
		try {
			return new ResponseEntity<>(hallServ.createHall(hall),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(hallServ.createHall(hall),HttpStatus.BAD_REQUEST);
		}
		
	}
	

}
