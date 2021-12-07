package com.cinema.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cinema.test.model.Booking;
import com.cinema.test.model.Customer;
import com.cinema.test.model.FunctionM;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	@Query("select booking from Booking booking where booking.function= :function and booking.status= :status ")
	List<Booking> getAllBookingByFunctionAndStatus(@Param("function") FunctionM function, @Param("status") String status);
	
	@Query("select booking from Booking booking where booking.customer=:customer_ and booking.function=:functionM ")
	List<Booking> findAllByCustomerAndFunction(@Param("customer_") Customer customer, @Param("functionM") FunctionM function);
}
