package com.cinema.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.test.DTO.ResponseListDTO;
import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.Booking;
import com.cinema.test.model.Customer;
import com.cinema.test.model.FunctionM;
import com.cinema.test.service.BookingService;

@RestController
@RequestMapping("/Booking")
public class BookingController {
	
	@Autowired
	 private BookingService bookingServ;
	
	@PostMapping("/UpdateBooking")
	public ResponseEntity<ResponseRegDTO> updateBooking(@RequestBody List<Booking> booking) {
		return new ResponseEntity<>(bookingServ.bookAllChairs(booking),HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/QueryAllAvalible")
	
	public ResponseEntity<ResponseListDTO> getAllAvalibleChairs(@RequestBody FunctionM functionm){
		try {
			return new ResponseEntity<>(new ResponseListDTO(bookingServ.getBookingByFunctionAvalible(functionm),"OK"),HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.toString());
			return new ResponseEntity<>(new ResponseListDTO(null,"Error"),HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/ReleaseSeat")
	public ResponseEntity<ResponseRegDTO> releaseSeat(@RequestBody List<Booking> booking){
		try {
			 return new ResponseEntity<>(bookingServ.freeChairs(booking),HttpStatus.OK);
		}
			
		catch(Exception e) {
			System.out.println(e.toString());
			return new ResponseEntity<>(new ResponseRegDTO("Error"),HttpStatus.BAD_REQUEST );
			}
	}
		
		
		@PostMapping("/ReleaseBooking")
		public ResponseEntity<ResponseRegDTO> releaseBooking(@RequestBody Customer customer, FunctionM functionM){
			try {

				return new ResponseEntity<>(bookingServ.freeBooking(customer, functionM),HttpStatus.OK );
			}
				
			catch(Exception e) {
				System.out.println(e.toString());
				return new ResponseEntity<>(new ResponseRegDTO("Error"),HttpStatus.BAD_REQUEST );
				}
	}

}
