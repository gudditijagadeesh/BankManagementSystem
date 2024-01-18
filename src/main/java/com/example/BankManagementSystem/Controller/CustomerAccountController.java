package com.example.BankManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementSystem.Model.CustomerAccount;
import com.example.BankManagementSystem.Service.CustomerAccountService;

@RestController
@RequestMapping("/api/customerAccounts")
public class CustomerAccountController {
	
	private final CustomerAccountService customerAccountService;
	
	
	@Autowired
	
	public CustomerAccountController(CustomerAccountService customerAccountService) {
		this.customerAccountService=customerAccountService;
	}
	
	@GetMapping("/allCustomers")
	public ResponseEntity<List<CustomerAccount>> getAllCustomerAccounts(){
		List<CustomerAccount> customerAccounts=customerAccountService.getAllCustomerAccounts();
		return new ResponseEntity<>(customerAccounts,HttpStatus.OK);
	}
	
	@PostMapping("/newCustomer")
	public ResponseEntity<CustomerAccount> createCustomerAccount(@RequestBody CustomerAccount customerAccount){
		CustomerAccount createdAccount=customerAccountService.createCustomerAccount(customerAccount);
		return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
	} 
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<CustomerAccount> updateCustomerAccount(
			@RequestParam String accountNumber,
			@RequestBody CustomerAccount updatedCustomerAccount){
		CustomerAccount updatedAccount=customerAccountService.updateCustomerAccount(accountNumber, updatedCustomerAccount);
		return updatedAccount != null ? new ResponseEntity<>(updatedAccount, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<Void> deleteCustomerAccount(@RequestParam String accountNumber){
		customerAccountService.deleteCustomerAccount(accountNumber);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getCustomer")
	public ResponseEntity<CustomerAccount> getCustomerAccountByAccountNumber(@RequestParam String accountNumber){
		try {
			Optional<CustomerAccount> customerAccount = customerAccountService.getCustomerAccountByAccountNumber(accountNumber);
		    return customerAccount.map(account -> new ResponseEntity<>(account, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	

}
