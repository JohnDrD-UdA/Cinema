package com.cinema.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.test.model.Movie;

@Service
public interface PeliculasService {
	String createMovie(Movie pelicula);
	Movie queryMovie(String movieName);
	String updateMovie(Movie pelicula);
	String deleteMovie(String user);
	String deleteMovie(Movie pelicula);
	List<Movie> getAllMovies();

}
