package com.example.BankManagementSystem.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class TransactionRequest {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "account_id" , nullable=false)
	private CustomerAccount account;
	private String fullName;
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	private LocalDateTime dateTime;
	
	private String accountNumber;
	
	@Column(name= "available_balance")
	private double availableBalance;
	
	
	
	
	
	public double getAvailableBalance() {
		return availableBalance;
	}



	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public TransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}



	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}



	public CustomerAccount getAccount() {
		return account;
	}



	public void setAccount(CustomerAccount account) {
		this.account = account;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public TransactionRequest(Long id, String accountNumber, String fullName, double amount, CustomerAccount account,
			TransactionType transactionType) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.amount = amount;
		this.account=account;
		this.transactionType = transactionType;
	}
	
	
	
	

}
