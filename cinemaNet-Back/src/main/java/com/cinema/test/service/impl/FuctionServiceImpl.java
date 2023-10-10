package com.cinema.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.Booking;

import com.cinema.test.model.FunctionM;
import com.cinema.test.model.Hall;
import com.cinema.test.model.Movie;
import com.cinema.test.repository.BookingRepository;
import com.cinema.test.repository.FunctionRepository;
import com.cinema.test.repository.HallRepository;
import com.cinema.test.repository.PeliculasRepository;
import com.cinema.test.service.FunctionService;

@Service
public class FuctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionRepository functionRep;
	
	@Autowired 
	private HallRepository hallRep;
	
	@Autowired
	private BookingRepository bookingRep;
	
	@Autowired
	private PeliculasRepository movieRep;

	@Override
	public List<FunctionM> getAllFunction() {
		return functionRep.findAll();
		
	}

	@Override
	public ResponseRegDTO createFunction(FunctionM fuction) {
		try {
			 Hall hallInfo=hallRep.getById(fuction.getHall().getId());
			 Movie movieInfo=movieRep.getById(fuction.getMovie().getId());
			 fuction.setHall(hallInfo);
			 fuction.setMovie(movieInfo);
			FunctionM savedFunction=functionRep.save(fuction);
			createChairs(savedFunction);
			return new ResponseRegDTO("OK");
		}
		catch(Exception e) {
			return new ResponseRegDTO("Error");
			
		}
	}

	@Override
	public List<FunctionM> getAllFunctionActive() {
		return functionRep.findByActive(true);
	}

	@Override
	public ResponseRegDTO updateFunction(FunctionM fuction) {
		try {
			functionRep.save(fuction);
			return new ResponseRegDTO("OK");
		}
		catch(Exception e) {
			return new ResponseRegDTO("Error");
			
		}
	}

	@Override
	public List<FunctionM> getAllFunctionByMovie(Movie movie) {
		return functionRep.findByMovie(movie);
	}
	
	private void createChairs(FunctionM function){
		 String rowID="ABCDEFGHIJKLMNOPQESTUVXYZ";
		 List<Booking> bookingList=new ArrayList<>();

		 
		 for(int i=0;i< function.getHall().getRows();i++) {
			 String row=rowID.substring(i, i+1);
			 for(int j=0;j< function.getHall().getCols();j++) {
				 Booking booking=new Booking();
				 String chairLocation=row+"-"+j;
				booking.setChairLocation(chairLocation);
				booking.setFunction(function);
				booking.setStatus("Avilable");
				bookingList.add(booking);
			 }
		 }
		 bookingRep.saveAll(bookingList);
		
	}
	@Override
	public List<Booking> getChairsAvalibleByFunction(FunctionM function){
		return bookingRep.getAllBookingByFunctionAndStatus(function, "Avilable");
	}
	
	public List<FunctionM> findAllByActiuveAndMovie(Movie movie){
		 return functionRep.findByActiveAndMovie(true, movie);
	}
	
	
	
	
	
	

}
