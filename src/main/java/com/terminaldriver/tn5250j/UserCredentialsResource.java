package com.terminaldriver.tn5250j;

import org.junit.rules.ExternalResource;

public class UserCredentialsResource extends ExternalResource {

	private String userid;
	
	private String password;
	
	public UserCredentialsResource() {
		this.userid = null;
		this.password = null;
	}
	
	public UserCredentialsResource fromVMArgs() {
		this.userid = System.getProperty("userid");
		this.password = System.getProperty("password");
		return this;
	}
	
	public String getUser() {
		return this.userid;
	}
	
	public String getPassword() {
		return this.password;
	}
}
