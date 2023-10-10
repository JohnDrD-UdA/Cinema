package com.cinema.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.test.model.Movie;
import com.cinema.test.repository.PeliculasRepository;
import com.cinema.test.service.PeliculasService;

@Service
public class PeliculasServiceImpl implements PeliculasService {
	@Autowired
	private PeliculasRepository peliculasRep;

	@Override
	public String createMovie(Movie pelicula) {
		try {
			peliculasRep.save(pelicula);
			return "Creacion exitosa";
		}
		catch(Exception e) {
			return e.toString();
			
		}
	}

	@Override
	public Movie queryMovie(String movieName) {
		return peliculasRep.findByMovieName(movieName);
	}

	@Override
	public String updateMovie(Movie pelicula) {
		try {
			peliculasRep.save(pelicula);
			return "Actualizacion exitosa";
		}
		catch(Exception e) {
			return "Error";
			
		}
	}

	@Override
	public String deleteMovie(String user) {
		return null;
	}

	@Override
	public String deleteMovie(Movie pelicula) {
		return null;
	}

	@Override
	public List<Movie> getAllMovies() {
		 return peliculasRep.findAll();
	}



}
