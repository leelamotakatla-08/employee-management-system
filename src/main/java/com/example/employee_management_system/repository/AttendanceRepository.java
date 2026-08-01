package com.example.employee_management_system.repository;

import com.example.employee_management_system.entity.Attendance;
import com.example.employee_management_system.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    /**
     * Find all attendance records for an employee.
     */
    List<Attendance> findByEmployee(Employee employee);

    /**
     * Find attendance records for a specific date.
     */
    List<Attendance> findByDate(LocalDate date);

    /**
     * Find attendance by employee and date.
     */
    Optional<Attendance> findByEmployeeAndDate(
            Employee employee,
            LocalDate date
    );

    /**
     * Check whether attendance is already marked.
     */
    boolean existsByEmployeeAndDate(
            Employee employee,
            LocalDate date
    );

    /**
     * Find attendance records between dates.
     */
    List<Attendance> findByDateBetween(
            LocalDate startDate,
            LocalDate endDate
    );

    /**
     * Find employee attendance between dates.
     */
    List<Attendance> findByEmployeeAndDateBetween(
            Employee employee,
            LocalDate startDate,
            LocalDate endDate
    );
}