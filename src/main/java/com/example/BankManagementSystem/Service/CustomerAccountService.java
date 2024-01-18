package com.example.BankManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankManagementSystem.Exception.CustomerAccountNotFoundException;
import com.example.BankManagementSystem.Exception.NotFoundException;
import com.example.BankManagementSystem.Model.CustomerAccount;
import com.example.BankManagementSystem.Repository.CustomerAccountRepository;

@Service
public class CustomerAccountService {
	
	private final CustomerAccountRepository  customerAccountRepository;
	
	@Autowired
	public CustomerAccountService(CustomerAccountRepository customerAccountRepository) {
		this.customerAccountRepository=customerAccountRepository;
	}
	
	public List<CustomerAccount> getAllCustomerAccounts(){
		return customerAccountRepository.findAll();
	}
	 
	public Optional<CustomerAccount> getCustomerAccountByAccountNumber(String accountNumber){
		return customerAccountRepository.findByAccountNumber(accountNumber);
	}
	
	public CustomerAccount createCustomerAccount(CustomerAccount customerAccount) {
		return customerAccountRepository.save(customerAccount);
	}
	
	public CustomerAccount updateCustomerAccount(String accountNumber,CustomerAccount updatedCustomerAccount) {
		Optional<CustomerAccount> customerAccount = customerAccountRepository.findByAccountNumber(accountNumber);
		if(customerAccount.isPresent()) {
			
			updatedCustomerAccount.setId(customerAccount.get().getId());
			return customerAccountRepository.save(updatedCustomerAccount);
		}
		return null;
	}
	public void deleteCustomerAccount(String accountNumber) {
		if(customerAccountRepository.existsByAccountNumber(accountNumber)) {
			customerAccountRepository.deleteByAccountNumber(accountNumber);
			
		}
		else {
			throw new NotFoundException("Customer account not found for accountNumber: "+ accountNumber);
		}
	}

}
