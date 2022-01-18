package com.cinema.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.Booking;
import com.cinema.test.model.Customer;
import com.cinema.test.model.FunctionM;

@Service
public interface BookingService {
	ResponseRegDTO createbooking(Booking booking);
	List<Booking> getBookingByCustomer(Customer customer);
	ResponseRegDTO updatebooking(Booking booking);
	List<Booking> getBookingByFunctionAvalible(FunctionM function);
	public ResponseRegDTO bookAllChairs(List<Booking> bookings);
	public ResponseRegDTO freeChairs(List<Booking> bookings);
	public ResponseRegDTO freeBooking(Customer customer, FunctionM functionM);
	
	public List<Booking> getAllChairs(FunctionM function);
	

	
	

}
