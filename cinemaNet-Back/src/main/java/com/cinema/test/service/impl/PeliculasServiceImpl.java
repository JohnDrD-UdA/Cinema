package com.cinema.test.service.impl;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovie(Movie pelicula) {
		// TODO Auto-generated method stub
		return null;
	}



}
