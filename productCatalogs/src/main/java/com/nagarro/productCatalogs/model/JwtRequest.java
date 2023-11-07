package com.nagarro.productCatalogs.model;

public class JwtRequest {
	
	String gmail;
	String password;
	
	
	
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public JwtRequest(String gmail, String password) {
		super();
		this.gmail = gmail;
		this.password = password;
	}
	
	
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "JwtRequest [gmail=" + gmail + ", password=" + password + "]";
	}
	
	

}
