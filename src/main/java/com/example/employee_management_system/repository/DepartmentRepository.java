package com.example.employee_management_system.repository;

import com.example.employee_management_system.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Find department by department code.
     */
    Optional<Department> findByDepartmentCode(String departmentCode);

    /**
     * Find department by department name.
     */
    Optional<Department> findByDepartmentName(String departmentName);

    /**
     * Check whether department code already exists.
     */
    boolean existsByDepartmentCode(String departmentCode);

    /**
     * Check whether department name already exists.
     */
    boolean existsByDepartmentName(String departmentName);
}