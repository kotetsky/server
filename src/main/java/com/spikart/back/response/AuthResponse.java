package com.spikart.back.response;

public class AuthResponse {
	
	private String jwt;
	private String message;

	public String getJwt() {
		return this.jwt;
	}

	public String getMessage() {
		return this.message;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthResponse() {

	}
	
	public AuthResponse(String jwt, String message) {
		super();
		this.jwt = jwt;
		this.message = message;
	}

}
