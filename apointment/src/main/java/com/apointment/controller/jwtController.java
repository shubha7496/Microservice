package com.apointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apointment.helper.JwtUtil;
import com.apointment.model.JwtRequest;
import com.apointment.model.JwtResponse;
import com.apointment.service.CustomUserDetailsService;



@RestController
public class jwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customerDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value="/token",method=RequestMethod.POST)
	public ResponseEntity<?> genrateToken(@RequestBody JwtRequest jwtRequest ) throws Exception
	{
		System.out.println(jwtRequest);
		try
		{
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));	
		}
		catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}catch(BadCredentialsException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		
		UserDetails userDetails=this.customerDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token=this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT " + token);
		return ResponseEntity.ok(new JwtResponse(token));
		
}
}