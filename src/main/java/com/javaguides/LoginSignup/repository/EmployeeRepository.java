package com.javaguides.LoginSignup.repository;

import com.javaguides.LoginSignup.entity.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);

    Optional<Employee> findOneByEmailAndPassword(String email, String password);
}
