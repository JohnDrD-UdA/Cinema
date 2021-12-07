package com.cinema.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cinema.test.model.FunctionM;
import com.cinema.test.model.Movie;

public interface FunctionRepository extends JpaRepository<FunctionM, Long> {
	
	@Query("select f from FunctionM f where f.active =:active and f.movie= :movie")
	List<FunctionM> findByActiveAndMovie(@Param("active") Boolean active,@Param("movie")  Movie movie);
	List<FunctionM> findByActive(Boolean active);
	List<FunctionM> findByMovie(Movie movie);
}
