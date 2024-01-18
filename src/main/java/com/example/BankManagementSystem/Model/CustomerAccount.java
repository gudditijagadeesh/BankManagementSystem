package com.example.BankManagementSystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;



/**
 * @author gudditijagadeesh
 *
 */

@Entity //It tells JPA provider that this class represents a table in the database
@Table(name="customer_accounts")
public class CustomerAccount {
	
	@Id  //Primary key field of the entity
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Specifies the strategy for the generation of primary key values.
	private Long id;
	
	
	private String firstName;
	private String secondName;
	private String fullName;
	
	private String gender;
	private String phonenumber;
	private String address;
	private String accountType;
	
	@Column(unique =true)  
	private String email;
	
	private String dateOfBirth;
	private double accountBalance;
	
	@Column(unique =true)
	private String accountNumber;
	
	@Column(unique =true)
	private String adharNumber;
	
	@Column(unique =true)
	private String panNumber;
	
	

	public CustomerAccount() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CustomerAccount(Long id, String firstName, String secondName, String fullName, String gender,
			String phonenumber, String address, String accountType, String email, String dateOfBirth,
			double accountBalance, String accountNumber, String adharNumber, String panNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.fullName = fullName;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.address = address;
		this.accountType = accountType;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.accountBalance = accountBalance;
		this.accountNumber = accountNumber;
		this.adharNumber = adharNumber;
		this.panNumber = panNumber;
	}







	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}



	public String getPanNumber() {
		return panNumber;
	}



	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
    
	

	
	
	@PrePersist
	private void generateAccountNumber() {
		
		//Generate a 12-digit random number for accountNo
		StringBuilder accountNumberBuilder=new StringBuilder();
		for(int i=0;i<12;i++) {
			int digit=(int) (Math.random() * 10);
			accountNumberBuilder.append(digit);
		}
		this.accountNumber = accountNumberBuilder.toString();
		}
	}
	


