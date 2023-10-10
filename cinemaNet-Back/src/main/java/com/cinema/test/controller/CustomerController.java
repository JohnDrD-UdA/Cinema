package com.cinema.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.Customer;
import com.cinema.test.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/crearCustomer")
	public ResponseEntity<ResponseRegDTO> createUser(@RequestBody Customer customer) {
		if(customer.checkUserName()) {
			String aux=customerService.createCustomer(customer);
		if(!aux.equals("Error en la creacion")) {
			return new ResponseEntity<>(new ResponseRegDTO("00"), HttpStatus.OK);
		}
		else {return new ResponseEntity<>(new ResponseRegDTO("01"), HttpStatus.FORBIDDEN);}
		}
		return new ResponseEntity<>(new ResponseRegDTO("02"), HttpStatus.BAD_REQUEST);
	}
}
