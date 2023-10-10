package com.cinema.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.test.model.Movie;
import com.cinema.test.service.PeliculasService;

@RestController
@RequestMapping("/movie")
public class PeliculasController {
	@Autowired
	private PeliculasService peliculasSer;
	@PostMapping("/crearMovie")
	public String createUser(@RequestBody Movie pelicula) {
			return peliculasSer.createMovie(pelicula);
	}

	
	@GetMapping("/query/{movieName}")
	public Movie queryUserByUserName(@PathVariable("movieName") String movieName) {
		 return peliculasSer.queryMovie(movieName);
	}
	@GetMapping("/getAllMovies")
	public List<Movie> getAllMovies(){
		return peliculasSer.getAllMovies();
	}

}
