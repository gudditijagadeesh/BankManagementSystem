package com.example.BankManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author gudditijagadeesh
 *
 */


@Entity
public class CustomerLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	
	private String password;
	
	
	
	
	public CustomerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}




	public CustomerLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}




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
	
	
	
	
}

