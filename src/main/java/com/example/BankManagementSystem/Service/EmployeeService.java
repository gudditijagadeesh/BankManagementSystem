package com.example.BankManagementSystem.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankManagementSystem.Model.Employee;
import com.example.BankManagementSystem.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	
	public boolean registerEmployee(Employee employee) {
		if(!employeeRepository.existsByUsername(employee.getUsername())) {
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}
	
	public boolean authenticateEmployee(String username, String password) {
		Optional<Employee> optionalEmployee=employeeRepository.findByUsername(username);
		return optionalEmployee.isPresent() && optionalEmployee.get().getPassword().equals(password);
	}
	

}
