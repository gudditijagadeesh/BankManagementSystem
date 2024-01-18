package com.example.BankManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeRegistration {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	private String fullName;
	private String username;
	private String password;
	private String email;
	
	
	
	public EmployeeRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeRegistration(Long employeeId, String fullName, String username, String password, String email) {
		super();
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	
	
	
}
