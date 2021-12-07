package com.cinema.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.test.model.Hall;

public interface HallRepository extends JpaRepository<Hall, Long>{
	

}
