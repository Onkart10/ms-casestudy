package com.ibm.accountms.model;

import java.io.Serializable;

public class AuthResponse implements Serializable {

	private static final long serialVersionUID = -2958245524535958575L;
	private String authToken;
	
	public AuthResponse() {}
	
	public AuthResponse(String authToken) {
		this.authToken = authToken;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	
}