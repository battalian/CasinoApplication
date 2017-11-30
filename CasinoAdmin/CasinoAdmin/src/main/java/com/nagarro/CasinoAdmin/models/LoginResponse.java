package com.nagarro.CasinoAdmin.models;

public class LoginResponse {

	private String access;

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public LoginResponse(String access) {
		super();
		this.access = access;
	}

	public LoginResponse() {
		super();
	}
	
}
