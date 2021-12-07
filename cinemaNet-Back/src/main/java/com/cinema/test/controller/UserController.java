package com.cinema.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.UserModel;
import com.cinema.test.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/crearUser")
	public ResponseEntity<ResponseRegDTO> createUser(@RequestBody UserModel user) {
		if(user.checkPassword() && user.checkUserName()) {
			String aux =userService.createUser(user);
			
			if(!aux.equals("error en la creacion")) {
				return new ResponseEntity<>(new ResponseRegDTO("00"), HttpStatus.OK);
			}
			else {return new ResponseEntity<>(new ResponseRegDTO("01"), HttpStatus.FORBIDDEN);}
			}
		return new ResponseEntity<>(new ResponseRegDTO("02"), HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/query/{userName}")
	public UserModel queryUserByUserName(@PathVariable("userName") String userName) {
		return userService.queryUser(userName);
	}
}
