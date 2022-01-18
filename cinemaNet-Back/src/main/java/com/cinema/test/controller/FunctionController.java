package com.cinema.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.test.DTO.ResponseListDTO;
import com.cinema.test.DTO.ResponseRegDTO;
import com.cinema.test.model.FunctionM;
import com.cinema.test.model.Movie;
import com.cinema.test.service.FunctionService;

@RestController
@RequestMapping("/FunctionM")
public class FunctionController {
	@Autowired 
	 private FunctionService functionServ;
	
	@PostMapping("/createFunctionM")
	
	public ResponseEntity<ResponseRegDTO> createFuntionM(@RequestBody FunctionM functionm){
		try {
		return new ResponseEntity<>( functionServ.createFunction(functionm),HttpStatus.OK );}
		catch(Exception e) {
			System.out.println(e.toString());
			return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST );
		}
		
	}
	
	@GetMapping("/QueryAllFunctions/{movieID}")
	public List<FunctionM>queryAllFunctions(@PathVariable("movieID") Long movieID)
	
		{ Movie movie=new Movie();
		  movie.setId(movieID);
			try {
				return functionServ.findAllByActiuveAndMovie(movie);
			}
			catch(Exception e) {
				System.out.println(e.toString());
				return null;
			}
		
		}

}
