package com.cinema.test.service;

import org.springframework.stereotype.Service;

import com.cinema.test.DTO.RequestAuthDTO;
import com.cinema.test.model.UserModel;

@Service
public interface UserService {

	String createUser(UserModel user);
	UserModel queryUser(String userName);
	String updateUser(UserModel user);
	String deleteUser(String user);
	String deleteUser(UserModel user);
	Boolean validatedCredencials(RequestAuthDTO requestAuthDTO);
}
