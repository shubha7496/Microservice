package com.apointment.model;

public class JwtResponse {
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	String token;
	 public JwtResponse()
	 {
		 
	 }
	public JwtResponse(String token) {
		this.token = token;
	}

}
