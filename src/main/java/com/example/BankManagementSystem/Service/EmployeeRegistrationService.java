package com.example.BankManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.BankManagementSystem.Model.EmployeeRegistration;
import com.example.BankManagementSystem.Repository.EmployeeRegistrationRepository;


@Service
public class EmployeeRegistrationService {
	

private final EmployeeRegistrationRepository employeeRegistrationRepository;
	
	@Autowired
	
	public EmployeeRegistrationService(EmployeeRegistrationRepository employeeRegistrationRepository) {
		this.employeeRegistrationRepository=employeeRegistrationRepository;
	}
	
	//Method save a new employee
	
	public EmployeeRegistration createEmployee(EmployeeRegistration employee) {
		return employeeRegistrationRepository.save(employee);
	}
	

	//Method to retrieve all employees
	
	public List<EmployeeRegistration> getAllEmployees(){
		return employeeRegistrationRepository.findAll();
	}
	
	//Method to find a customer by ID
	
	public Optional<EmployeeRegistration> findEmployeeById(String employeeId){
		return employeeRegistrationRepository.findById(employeeId);
		
	}
	
	//Method to update an existing employee
	
	public EmployeeRegistration updateEmployee(String employeeId,EmployeeRegistration updatedEmployeeDetails) {
		Optional<EmployeeRegistration> optionalEmployee=employeeRegistrationRepository.findById(employeeId);
		if(optionalEmployee.isPresent()) {
			EmployeeRegistration existingEmployee=optionalEmployee.get();
			
			//Update the existing customer details with the new details
			existingEmployee.setFullName(updatedEmployeeDetails.getFullName());
			existingEmployee.setEmail(updatedEmployeeDetails.getEmail());
			
			//Save the updated customer details
			return employeeRegistrationRepository.save(existingEmployee);
		}
		else {
			//For example , throw an exception or return null
			return null;
		}
		
	}
	
	// Method to delete employee by ID
	public void deleteEmployeeById(String employeeId) {
		employeeRegistrationRepository.deleteById(employeeId);
	}


}
