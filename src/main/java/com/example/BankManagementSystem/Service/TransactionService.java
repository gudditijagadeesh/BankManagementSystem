package com.example.BankManagementSystem.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankManagementSystem.Model.CustomerAccount;
import com.example.BankManagementSystem.Model.TransactionRequest;
import com.example.BankManagementSystem.Model.TransactionType;
import com.example.BankManagementSystem.Repository.TransactionRequestRepository;



//@Service
//public class TransactionService {
//	
//	private final TransactionRequestRepository transactionRequestRepository;
//	private final CustomerAccountService customerAccountService;
//	@Autowired
//	public TransactionService(TransactionRequestRepository transactionRequestRepository,CustomerAccountService customerAccountService) {
//		this.transactionRequestRepository=transactionRequestRepository;
//		this.customerAccountService=customerAccountService;
//	}
//	
//	
//	public void recordTransaction(CustomerAccount account, double amount, TransactionType transactionType) {
//		TransactionRequest transaction= new TransactionRequest();
//		
//		transaction.setAccount(account);
//		transaction.setAccountNumber(account.getAccountNumber());
//		transaction.setFullName(account.getFullName());
//		transaction.setDateTime(LocalDateTime.now());
//		transaction.setTransactionType(transactionType);
//		transaction.setAmount(amount);
//		transactionRequestRepository.save(transaction);
//	}
//	
//	public List<TransactionRequest> getTransactionHistoryByAccountNumber(String accountNumber){
//		
//		Optional<CustomerAccount> optionalAccount= customerAccountService.getCustomerAccountByAccountNumber(accountNumber);
//		return optionalAccount.map(customerAccount ->{
//			List<TransactionRequest> transactions=transactionRequestRepository.findByAccount(customerAccount);
//			transactions.forEach(transaction -> {
//				transaction.setFullName(customerAccount.getFullName());
//				transaction.setAccountNumber(customerAccount.getAccountNumber());
//				
//			});
//			return transactions;
//			
//		}).orElse(List.of());
//		
//	}
//	
//
//}

@Service
public class TransactionService {
	
	private final TransactionRequestRepository transactionRequestRepository;
	private final CustomerAccountService customerAccountService;
	@Autowired
	public TransactionService(TransactionRequestRepository transactionRequestRepository,CustomerAccountService customerAccountService) {
		this.transactionRequestRepository=transactionRequestRepository;
		this.customerAccountService=customerAccountService;
	}
	
	
	public void recordTransaction(CustomerAccount account, double amount, TransactionType transactionType) {
		TransactionRequest transaction= new TransactionRequest();
		
		transaction.setAccount(account);
		transaction.setAccountNumber(account.getAccountNumber());
		transaction.setFullName(account.getFullName());
		transaction.setDateTime(LocalDateTime.now());
		transaction.setTransactionType(transactionType);
		transaction.setAmount(amount);
		
		double availableBalance=account.getAccountBalance();
//		if(transactionType == TransactionType.CREDIT) {
//
//			availableBalance += amount;
//			
//		}
//		else if(transactionType == TransactionType.DEBIT) {
//			availableBalance -= amount;
//		}

		transaction.setAvailableBalance(availableBalance);
		transactionRequestRepository.save(transaction);
		
	}

	
	public List<TransactionRequest> getTransactionHistoryByAccountNumber(String accountNumber){
		
		Optional<CustomerAccount> optionalAccount= customerAccountService.getCustomerAccountByAccountNumber(accountNumber);
		return optionalAccount.map(customerAccount ->{
			List<TransactionRequest> transactions=transactionRequestRepository.findByAccount(customerAccount);
			
//			double availableBalance=customerAccount.getAccountBalance();
			for(TransactionRequest transaction: transactions) {
				transaction.setFullName(customerAccount.getFullName());
				transaction.setAccountNumber(customerAccount.getAccountNumber());
				
//				transaction.setAvailableBalance(availableBalance);
				
			}
			return transactions;
			
		}).orElse(List.of());
		
	}
	

}











