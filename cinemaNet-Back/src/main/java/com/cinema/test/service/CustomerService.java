package com.cinema.test.service;

import org.springframework.stereotype.Service;


import com.cinema.test.model.Customer;
@Service
public interface CustomerService {
	String createCustomer(Customer customer);
	Customer queryUser(String userName);
	String updateUser(Customer customerr);
	String deleteUser(String userName);
	String deleteUser(Customer customer);

}
