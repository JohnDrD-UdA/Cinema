package com.cinema.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.test.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Customer findByUserName(String userName);

}
