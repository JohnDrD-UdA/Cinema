package com.cinema.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.test.DTO.RequestAuthDTO;
import com.cinema.test.model.UserModel;
import com.cinema.test.repository.UserRepository;
import com.cinema.test.service.UserService;
import com.cinema.test.utils.EncryptPassword;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EncryptPassword encryptPassword;


	@Override
	public String createUser(UserModel user) {
		
		try {
			user.setPassword(encryptPassword.encoder().encode(user.getPassword()));
			userRepository.save(user);
			return "creacion exitosa";
		}catch(Exception e) {
			return "error en la creacion";
		}
		
	}

	@Override
	public UserModel queryUser(String userName) {		
		return userRepository.findByUserName(userName);		
	}

	@Override
	public String updateUser(UserModel user) {
		try {
			userRepository.save(user);
			return "actualizacion exitosa";
		}catch(Exception e) {
			return "error en la actualizacion";
		}
	}

	@Override
	public String deleteUser(String user) {
		return null;
	}

	@Override
	public String deleteUser(UserModel user) {
		return null;
	}
	
	@Override
	public Boolean validatedCredencials(RequestAuthDTO requestAuthDTO) {
		try {
			UserModel user= userRepository.findByUserName(requestAuthDTO.getUserName());
			if(user != null) {
				return encryptPassword.encoder().matches(requestAuthDTO.getPassword(), user.getPassword());
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}

}
