package com.apointment.model;

public class JwtRequest {
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String username;
	String password;
	
	public JwtRequest() {

	}
	public JwtRequest(String username, String password) {

		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "jwtRequest [username=" + username + ", password=" + password + "]";
	}
	

}
