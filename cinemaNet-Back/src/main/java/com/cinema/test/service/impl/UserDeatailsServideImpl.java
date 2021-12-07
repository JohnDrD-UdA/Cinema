package com.cinema.test.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cinema.test.model.UserModel;
import com.cinema.test.repository.UserRepository;

@Service
public class UserDeatailsServideImpl  implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userDetails = userRepository.findByUserName(username);		
		return new User(userDetails.getUserName(), userDetails.getPassword(), new ArrayList<>());
	}

}
