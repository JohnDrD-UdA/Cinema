package com.cinema.test.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cinema.test.service.impl.UserDeatailsServideImpl;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDeatailsServideImpl userDeatailsServideImpl;
	
	@Autowired
	private JWTFilterRequest jWTFilterRequest;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDeatailsServideImpl);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**/autentication").permitAll()
		.antMatchers("/**/crearUser").permitAll()
		.antMatchers("/**/crearMovie").permitAll()
		.antMatchers("/v2/api-docs").permitAll()
        .antMatchers("/configuration/ui").permitAll()
        .antMatchers("/swagger-resources/**").permitAll()
        .antMatchers("/configuration/security").permitAll()
        .antMatchers("/swagger-ui.html").permitAll()
        .antMatchers("/swagger-ui/*").permitAll()
        .antMatchers("/webjars/**").permitAll()
        .antMatchers("/v2/**").permitAll()
        .antMatchers("/**/createHall").permitAll()
        .antMatchers("/**/createFunctionM").permitAll()
        .antMatchers("/**/QueryAllFunctions").permitAll()
        .antMatchers("/**/QueryAllAvalible").permitAll()
        .antMatchers("/**/UpdateBooking").permitAll()
        .antMatchers("/**/ReleaseSeat").permitAll()
        .antMatchers("/**/ReleaseBooking").permitAll()
        
		.antMatchers("/**/crearCustomer").permitAll().anyRequest().authenticated();
		
		http.addFilterBefore(jWTFilterRequest, UsernamePasswordAuthenticationFilter.class);
		
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {		
		return super.authenticationManager();
	}
	
	

}
//.antMatchers("/**/crearCustomer")