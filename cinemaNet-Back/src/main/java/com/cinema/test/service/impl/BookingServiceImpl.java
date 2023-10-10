package com.cinema.test.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.Booking;
import com.cinema.test.model.Customer;
import com.cinema.test.model.FunctionM;
import com.cinema.test.repository.BookingRepository;
import com.cinema.test.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository bookingRep;
	ResponseRegDTO errorRes=new ResponseRegDTO("error");

	@Override
	public ResponseRegDTO createbooking(Booking booking) {
		try {
			bookingRep.save(booking);
			return new ResponseRegDTO("OK");
		}
		catch(Exception e) {
			return this.errorRes;
		}
	}

	@Override
	public List<Booking> getBookingByCustomer(Customer customer) {
		
		return Collections.emptyList();
	}

	@Override
	public ResponseRegDTO updatebooking(Booking booking) {
		try {
			bookingRep.save(booking);
			return new ResponseRegDTO("OK");
		}
		catch(Exception e) {
			return this.errorRes;
		}
	}
	
	@Override
	public ResponseRegDTO bookAllChairs(List<Booking> bookings) 
		{ 
			Booking auxiliarBooking;
			ResponseRegDTO auxiliarResponse= new ResponseRegDTO("");
			try {
			for(int i =0;i<bookings.size();i++) {
				
				auxiliarBooking=bookingRep.getById(bookings.get(i).getId());
				
				if(auxiliarBooking.getCustomer()==null) {
					auxiliarResponse=updatebooking(bookings.get(i));	
				}
			
			}
			auxiliarResponse.setStatus("OK");
			return auxiliarResponse;
			}
			catch(Exception e) {
				auxiliarResponse.setStatus("Error");
				return auxiliarResponse;
			}
		
		}
	
	@Override
	public List<Booking> getBookingByFunctionAvalible(FunctionM function) {
		
		return bookingRep.getAllBookingByFunctionAndStatus(function, "Avilable");
	}
	
	@Override
	public ResponseRegDTO freeChairs(List<Booking> bookings) 
		{		
			Booking auxiliarBooking;
			Booking auxiliarBooking2;
			ResponseRegDTO auxiliarResponse= new ResponseRegDTO("");
			try {
			
				for(int i =0;i<bookings.size();i++) {
					
				auxiliarBooking=bookingRep.getById(bookings.get(i).getId());
				auxiliarBooking2=bookings.get(i);
				
				if(auxiliarBooking.getCustomer().getId().equals(auxiliarBooking2.getCustomer().getId())) {
					
					auxiliarBooking2.setCustomer(null);
					auxiliarResponse=updatebooking(auxiliarBooking2);	
				}
			
			}
			auxiliarResponse.setStatus("OK");
			return auxiliarResponse;
			}
			catch(Exception e) {
				auxiliarResponse.setStatus("Error");
				return auxiliarResponse;
			}
		
		
		}
	
	@Override
	public ResponseRegDTO freeBooking(Customer customer, FunctionM functionM) {
		List<Booking> bookingsByCustomer=bookingRep.findAllByCustomerAndFunction(customer, functionM);
		try {
		for(int i=0;i<bookingsByCustomer.size();i++) {
			bookingsByCustomer.get(i).setCustomer(null);
			updatebooking(bookingsByCustomer.get(i));
			
		}
		return new ResponseRegDTO("OK");
		}
		catch(Exception e) {
			return this.errorRes;
		}
		
	}

	@Override
	public List<Booking> getAllChairs(FunctionM function) {
		return bookingRep.getAllByFunctionM(function);
	}
}
