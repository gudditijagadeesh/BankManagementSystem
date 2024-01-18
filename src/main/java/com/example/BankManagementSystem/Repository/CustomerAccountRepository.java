package com.example.BankManagementSystem.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankManagementSystem.Model.CustomerAccount;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long>{

//	List<CustomerAccount> findByFullName(String fullName);
	Optional<CustomerAccount> findByAccountNumber(String accountNumber);

	Optional<CustomerAccount> findByFullName(String fullName);

	void deleteByAccountNumber(String accountNumber);

	boolean existsByAccountNumber(String accountNumber);
	

}
