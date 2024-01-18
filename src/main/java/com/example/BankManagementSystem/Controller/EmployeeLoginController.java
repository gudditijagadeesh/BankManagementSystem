package com.example.BankManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.BankManagementSystem.Service.EmployeeLoginService;



@RestController
@RequestMapping("/Employeelogin")
public class EmployeeLoginController {
	private final EmployeeLoginService employeeLoginService;
	
	@Autowired
	
	private EmployeeLoginController(EmployeeLoginService employeeLoginService) {
		this.employeeLoginService=employeeLoginService;
	}
	
	
	@PostMapping("/login")
	
	public ResponseEntity<String> login(@RequestParam String username , @RequestParam String password){
		boolean isValid=employeeLoginService.verifyLoginCredentials(username,password);
		if(isValid) {
			return new ResponseEntity<>("Login Successful",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PutMapping("/updatepassword")
	public ResponseEntity<String> changePassword(@RequestParam String username, @RequestParam String password){
		String result = employeeLoginService.updatePassword(username, password);
		if(result.equals("Successfully updated"))
				{
			return new ResponseEntity<>("Password changed successfully",HttpStatus.OK);
		}
		else if(result.equals("Username not found")) {
			return new ResponseEntity<>("Username not found", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>("Failed to change password. Please check your password.", HttpStatus.BAD_REQUEST);
		}
		
		
		
		
		
		
	}

}
