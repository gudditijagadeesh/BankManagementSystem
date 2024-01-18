package com.example.BankManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementSystem.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	boolean existsByUsername(String username);

	Optional<Employee> findByUsername(String username);

}
