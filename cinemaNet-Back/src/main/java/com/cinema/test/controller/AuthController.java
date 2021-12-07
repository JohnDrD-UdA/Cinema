package com.cinema.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.test.DTO.RequestAuthDTO;
import com.cinema.test.DTO.ResponseAuthDTO;
import com.cinema.test.service.UserService;
import com.cinema.test.service.impl.UserDeatailsServideImpl;
import com.cinema.test.utils.JWTUtil;

@RestController
@RequestMapping("/security")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDeatailsServideImpl userDeatailsServideImpl;
	
	@Autowired
	private JWTUtil jwtUtil;	
	
	@PostMapping("/autentication")
	public ResponseEntity<ResponseAuthDTO> autentication(@RequestBody RequestAuthDTO requestAuthDTO){
		try {
			if(userService.validatedCredencials(requestAuthDTO)) {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestAuthDTO.getUserName(), requestAuthDTO.getPassword()));
				UserDetails userDetails = userDeatailsServideImpl.loadUserByUsername(requestAuthDTO.getUserName());
				
				String token = jwtUtil.generatedToken(userDetails);
				
				return new ResponseEntity<>(new ResponseAuthDTO("00", token), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new ResponseAuthDTO("01", null), HttpStatus.FORBIDDEN);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(new ResponseAuthDTO("02", null), HttpStatus.UNAUTHORIZED);
		}
		
	}

}
