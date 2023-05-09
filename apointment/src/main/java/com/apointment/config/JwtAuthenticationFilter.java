package com.apointment.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

import com.apointment.helper.JwtUtil;
import com.apointment.service.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private ObjectMapper mapper;

	@Autowired
	private CustomUserDetailsService customUserDetailsService; 
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("testing userts");
		
		 String requestTokenHeader=request.getHeader("Authorization");
		
		String username=null;
		String jwtToken=null;
		
		
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken=requestTokenHeader.substring(7);
			
			try{
				username=this.jwtUtil.getUsernameFromToken(jwtToken);
				System.out.println("username "+username);
			}catch(Exception e) {	
				e.printStackTrace();	
			}
			UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(username);
			
		
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
				//UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken( userDetails,null,userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				//filterChain.doFilter(request,response);
			}else {
				System.out.println(" Token is not validated");
				
//				 Map<String, Object> errorDetails = new HashMap<>();
//				   
//				  errorDetails.put("message", "Invalid token");
//
//				  ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//				  ((HttpServletResponse) response).setContentType("application/json");

			    //  mapper.writeValue(((HttpServletResponse) response).getWriter(), errorDetails);
			}
			
		}
		
		filterChain.doFilter(request,response);

		
	}
	

}
