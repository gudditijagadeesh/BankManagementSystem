package com.example.BankManagementSystem.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankManagementSystem.Model.EmployeeLogin;

import com.example.BankManagementSystem.Repository.EmployeeLoginRepository;


@Service
public class EmployeeLoginService {
	
	private final EmployeeLoginRepository employeeLoginRepository;
	   
	@Autowired
	
	public EmployeeLoginService(EmployeeLoginRepository employeeLoginRepository) {
		this.employeeLoginRepository=employeeLoginRepository;
	}
	
	
	//Method to verify login credentials
	
	public boolean verifyLoginCredentials(String username, String password) {
		
		Optional<EmployeeLogin> employeeLogin=employeeLoginRepository.findByUsername(username);
		return employeeLogin.isPresent() && employeeLogin.get().getPassword().equals(password);
		
	}
	
	//Method to find a bank login by Username
	
	public EmployeeLogin findByLoginByUsername(String username){
		return employeeLoginRepository.findByUsername(username).orElse(null);
	}
	
	 
	//Method to update password
	
	public String updatePassword(String username, String newPassword) {
		EmployeeLogin employeeLogin=employeeLoginRepository.findByUsername(username).orElse(null);
		if(employeeLogin != null) {
			employeeLogin.setPassword(newPassword);
			employeeLoginRepository.save(employeeLogin);
			return "Successfully updated";
		}
		return "Username not found";
	}

}



