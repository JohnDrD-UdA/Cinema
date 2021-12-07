package com.cinema.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.test.model.Movie;

public interface PeliculasRepository extends JpaRepository<Movie, Long>  {
	Movie findByMovieName(String movieName);
}
