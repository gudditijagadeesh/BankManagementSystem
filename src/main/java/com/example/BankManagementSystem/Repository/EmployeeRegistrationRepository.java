package com.example.BankManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankManagementSystem.Model.EmployeeRegistration;


public interface EmployeeRegistrationRepository extends JpaRepository<EmployeeRegistration, String>{

}
