package com.cinema.test.configure;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cinema.test.service.impl.UserDeatailsServideImpl;
import com.cinema.test.utils.JWTUtil;

@Component
public class JWTFilterRequest extends OncePerRequestFilter{
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserDeatailsServideImpl userDeatailsServideImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String autorizationHeader = request.getHeader("Authorization");
		
		try {
			if(autorizationHeader != null && autorizationHeader.startsWith("Bearer")) {
				String token = autorizationHeader.substring(7);
				String userName = jwtUtil.getUsernameToken(token);
				
				if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					UserDetails userDetails = userDeatailsServideImpl.loadUserByUsername(userName);
					
					if(jwtUtil.validatedToken(token, userDetails)) {
						
						UsernamePasswordAuthenticationToken usernameAuthentication = new UsernamePasswordAuthenticationToken(userDetails, null,  userDetails.getAuthorities());
						usernameAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						
						SecurityContextHolder.getContext().setAuthentication(usernameAuthentication);
					}
					
				}
				
			}
			filterChain.doFilter(request, response);
		}catch(Exception e) {
			response.setStatus(401);
		}
		
	}

}
