package com.example.employee_management_system.repository;

import com.example.employee_management_system.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}
