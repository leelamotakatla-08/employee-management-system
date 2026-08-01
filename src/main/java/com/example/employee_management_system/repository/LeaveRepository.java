package com.example.employee_management_system.repository;

import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.entity.Leave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {

    /**
     * Find all leave requests of an employee.
     */
    List<Leave> findByEmployee(Employee employee);

    /**
     * Find leave requests by status.
     */
    List<Leave> findByStatus(String status);

    /**
     * Find leave requests of an employee by status.
     */
    List<Leave> findByEmployeeAndStatus(
            Employee employee,
            String status
    );

    /**
     * Find leave requests starting between two dates.
     */
    List<Leave> findByStartDateBetween(
            LocalDate startDate,
            LocalDate endDate
    );

    /**
     * Check if employee already has leave starting on a specific date.
     */
    boolean existsByEmployeeAndStartDate(
            Employee employee,
            LocalDate startDate
    );
}