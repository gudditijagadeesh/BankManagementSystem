package com.example.BankManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementSystem.Model.CustomerAccount;
import com.example.BankManagementSystem.Model.TransactionRequest;

public interface TransactionRequestRepository extends JpaRepository<TransactionRequest, Long>{

	List<TransactionRequest> findByAccount(CustomerAccount customerAccount);


}
