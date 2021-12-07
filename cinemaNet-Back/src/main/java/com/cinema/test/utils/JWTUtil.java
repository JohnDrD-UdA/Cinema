package com.cinema.test.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cinema.test.model.UserModel;
import com.cinema.test.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

@Component
public class JWTUtil {

	@Autowired
	private UserRepository userRepository;
	
	private static final String KEY= "akmsndbuikasdhas78sadghfbsdfjgw8743fasjayei4ruweuihnfs8e5yr93h48ytrh3e48t8e4t87t84e5JHGVUYKD";
	
	public String generatedToken(UserDetails userDetails) {
		
		UserModel userInfo = userRepository.findByUserName(userDetails.getUsername());
		
		return Jwts.builder().setSubject(userInfo.getUserName()).setIssuedAt(new Date())
		.setExpiration(new Date(System.currentTimeMillis() +1000 * 60 * 30))
		.claim("userName", userInfo.getUserName())
		.signWith(SignatureAlgorithm.HS256, KEY).compact();		
		
	}
	
	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
	}
	
	public String getUsernameToken(String token) {
		return getClaims(token).getSubject();
	}
	
	public Boolean validatedToken(String token, UserDetails userDetails) {
		return userDetails.getUsername().equals(getUsernameToken(token)) && !isExpiredToken(token);
	}
	
	private Boolean isExpiredToken(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}
}
