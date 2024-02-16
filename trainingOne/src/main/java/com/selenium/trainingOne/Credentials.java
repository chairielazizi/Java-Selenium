package com.selenium.trainingOne;

public class Credentials {

	public static String username = "##############";
	public static String password = "##############";
	
	
	public Credentials() {
		super();
	}
	
	public Credentials(String user, String pass) {
		username = user;
		password = pass;
	}
	
	public String toString() {
		return "Username: " + username + ", Password: " + password;
	}

}
