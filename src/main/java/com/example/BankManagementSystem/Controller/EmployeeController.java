package com.example.BankManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementSystem.Model.Employee;
import com.example.BankManagementSystem.Service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@PostMapping("/register")
	public String registerEmployee(@RequestBody Employee employee) {
		if(employeeService.registerEmployee(employee)) {
			return "Registration Successfull";
		}
		else {
			return "username already exists";
		}
	}
	@PostMapping("/authenticate")
	public String authenticateEmployee(@RequestParam String username, @RequestParam String password) {
		if(employeeService.authenticateEmployee(username, password)) {
			return "Login successfull!";
			
		}
		else {
			return "Invalid username or password";
		}
	}
	
	
	
	

}
