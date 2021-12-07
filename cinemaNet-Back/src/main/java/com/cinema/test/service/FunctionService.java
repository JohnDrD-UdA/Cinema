package com.cinema.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.Booking;
import com.cinema.test.model.FunctionM;
import com.cinema.test.model.Movie;

@Service
public interface FunctionService {
	List<FunctionM> getAllFunction();
	ResponseRegDTO createFunction(FunctionM fuction);
	List<FunctionM> getAllFunctionActive();
	ResponseRegDTO updateFunction(FunctionM fuction);
	List<FunctionM> getAllFunctionByMovie(Movie movie);
	List<Booking> getChairsAvalibleByFunction(FunctionM function);
	List<FunctionM> findAllByActiuveAndMovie(Movie movie);


}
