package com.connect;

import javax.jws.WebService;
import connection.DatabaseConnection;

@WebService
public class Service {

	DatabaseConnection db = new DatabaseConnection();

	public String signUp(String firstname, String lastname, String emailid, String password) {
		System.out.println("Inside Signup");
		String result;

		result = db.signUp(firstname, lastname, emailid, password);
		return result;
	}
	
	public Client signIn(String username, String password) {
		System.out.println("Inside Signin");
		Client clientObj;

		clientObj = db.signIn(username, password);
		return clientObj;
	}

}
