package com.example.BankManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementSystem.Model.EmployeeLogin;

public interface EmployeeLoginRepository extends JpaRepository<EmployeeLogin, Long>{

	Optional<EmployeeLogin> findByUsername(String username);

}
