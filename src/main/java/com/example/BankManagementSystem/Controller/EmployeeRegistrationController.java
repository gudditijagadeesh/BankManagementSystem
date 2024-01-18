package com.example.BankManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementSystem.Model.EmployeeRegistration;
import com.example.BankManagementSystem.Service.EmployeeRegistrationService;


@RestController
@RequestMapping("/Employees")
public class EmployeeRegistrationController {
	
private final EmployeeRegistrationService employeeRegistrationService;
	
	@Autowired
	
	public EmployeeRegistrationController(EmployeeRegistrationService employeeRegistrationService) {
		this.employeeRegistrationService=employeeRegistrationService;
	}
	
	@PostMapping("/register")
    public ResponseEntity<EmployeeRegistration> registerEmployee(@RequestBody EmployeeRegistration employee){
		EmployeeRegistration createdEmployee= employeeRegistrationService.createEmployee(employee);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/getallemployees")
	public ResponseEntity<List<EmployeeRegistration>> getAllEmployees(){
		List<EmployeeRegistration> employees= employeeRegistrationService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/getemployee")
	public ResponseEntity<EmployeeRegistration> getEmployeeById(@RequestParam String employeeId){
		Optional<EmployeeRegistration> employee=employeeRegistrationService.findEmployeeById(employeeId);
		return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
