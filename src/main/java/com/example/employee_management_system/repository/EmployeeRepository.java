package com.example.employee_management_system.repository;

import com.example.employee_management_system.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Find employee by employee code.
     */
    Optional<Employee> findByEmployeeCode(String employeeCode);

    /**
     * Find employee by email.
     */
    Optional<Employee> findByEmail(String email);

    /**
     * Find employee using login username.
     */
    Optional<Employee> findByUserUsername(String username);

    /**
     * Check if employee code already exists.
     */
    boolean existsByEmployeeCode(String employeeCode);

    /**
     * Check if email already exists.
     */
    boolean existsByEmail(String email);
}