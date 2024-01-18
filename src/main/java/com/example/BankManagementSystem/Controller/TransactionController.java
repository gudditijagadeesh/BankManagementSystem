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

import com.example.BankManagementSystem.Model.CustomerAccount;
import com.example.BankManagementSystem.Model.TransactionRequest;
import com.example.BankManagementSystem.Model.TransactionType;
import com.example.BankManagementSystem.Service.CustomerAccountService;
import com.example.BankManagementSystem.Service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	
	private final CustomerAccountService customerAccountService;
	private final TransactionService transactionService;
	
	@Autowired
	public TransactionController(CustomerAccountService customerAccountService, TransactionService transactionService) {
		this.customerAccountService=customerAccountService;
		this.transactionService= transactionService;
	}
	
//	@PostMapping("/processTransaction")
//	
//	public ResponseEntity<String> processTransaction(@RequestBody TransactionRequest transactionRequest){
//		String accountNumber= transactionRequest.getAccountNumber();
//		double amount=transactionRequest.getAmount();
//		TransactionType transactionType=transactionRequest.getTransactionType();
////		String fullName= transactionRequest.getFullName();
//		
//		Optional<CustomerAccount> optionalAccount=customerAccountService.getCustomerAccountByAccountNumber(accountNumber);
//		
//		if(optionalAccount.isPresent()) {
//			CustomerAccount account=optionalAccount.get();
//			
//			if(transactionType == TransactionType.CREDIT) {
//				System.out.println(account.getAccountBalance());
//				account.setAccountBalance(account.getAccountBalance() + amount);
//				System.out.println(account.getAccountBalance());
//			}
//
//			else if(transactionType == TransactionType.DEBIT) {
//				double newBalance= account.getAccountBalance()- amount;
//				if(newBalance >=0) {
//					account.setAccountBalance(newBalance);
//				}
//				else {
//					return new ResponseEntity<>("Insufficient funds for debit", HttpStatus.BAD_REQUEST);
//				}
//			}
//			
//			customerAccountService.updateCustomerAccount (accountNumber, account);
//			transactionService.recordTransaction(account, amount, transactionType);
//			
//			return new ResponseEntity<>("Transaction processed successfully", HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>("Customer account not found", HttpStatus.NOT_FOUND);
//			
//		}
//	}
//	
//	@GetMapping("/getTransactionHistory")
//	public ResponseEntity<List<TransactionRequest>> getTransactionHistory(@RequestParam String accountNumber){
//		List<TransactionRequest> transactionHistory=transactionService.getTransactionHistoryByAccountNumber(accountNumber);
//		return new ResponseEntity<>(transactionHistory,HttpStatus.OK);
//	}
	
@PostMapping("/processTransaction")
	
	public ResponseEntity<String> processTransaction(@RequestBody TransactionRequest transactionRequest){
		String accountNumber= transactionRequest.getAccountNumber();
		double amount=transactionRequest.getAmount();
		TransactionType transactionType=transactionRequest.getTransactionType();
//		String fullName= transactionRequest.getFullName();
		
		Optional<CustomerAccount> optionalAccount=customerAccountService.getCustomerAccountByAccountNumber(accountNumber);
		
		if(optionalAccount.isPresent()) {
			CustomerAccount account=optionalAccount.get();
			
			if(transactionType == TransactionType.CREDIT) {
//				System.out.println(account.getAccountBalance());
				account.setAccountBalance(account.getAccountBalance() + amount);
				
			}

			else if(transactionType == TransactionType.DEBIT) {
				double newBalance= account.getAccountBalance()- amount;
				if(newBalance >=0) {
					account.setAccountBalance(newBalance);
				}
				else {
					return new ResponseEntity<>("Insufficient funds for debit", HttpStatus.BAD_REQUEST);
				}
			}
			
			customerAccountService.updateCustomerAccount (accountNumber, account);
			transactionService.recordTransaction(account, amount, transactionType);
			
			return new ResponseEntity<>("Transaction processed successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Customer account not found", HttpStatus.NOT_FOUND);
			
		}
	}
	
	@GetMapping("/getTransactionHistory")
	public ResponseEntity<List<TransactionRequest>> getTransactionHistory(@RequestParam String accountNumber){
		List<TransactionRequest> transactionHistory=transactionService.getTransactionHistoryByAccountNumber(accountNumber);
		return new ResponseEntity<>(transactionHistory,HttpStatus.OK);
	}

	
}
