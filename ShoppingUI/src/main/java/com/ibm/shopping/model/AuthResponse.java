package com.ibm.shopping.model;

import java.io.Serializable;

public class AuthResponse implements Serializable {

	private static final long serialVersionUID = -2958245524535958575L;
	private String authToken;
	
	public AuthResponse() {}
	
	public AuthResponse(String jwttoken) {
		this.authToken = jwttoken;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String jwttoken) {
		this.authToken = jwttoken;
	}

	
}