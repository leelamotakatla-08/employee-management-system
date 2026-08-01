package com.example.employee_management_system.service;

import com.example.employee_management_system.dto.EmployeeDTO;

import java.util.List;

/**
 * Service interface for Employee Management.
 */
public interface EmployeeService {

    /**
     * Create a new employee.
     *
     * @param employeeDTO employee details
     * @return created employee
     */
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    /**
     * Retrieve all employees.
     *
     * @return list of employees
     */
    List<EmployeeDTO> getAllEmployees();

    /**
     * Retrieve an employee by ID.
     *
     * @param id employee ID
     * @return employee details
     */
    EmployeeDTO getEmployeeById(Long id);

    /**
     * Update employee details.
     *
     * @param id employee ID
     * @param employeeDTO updated employee details
     * @return updated employee
     */
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    /**
     * Delete an employee.
     *
     * @param id employee ID
     */
    void deleteEmployee(Long id);

    /**
     * Get the profile of the currently logged-in employee.
     *
     * @param username authenticated username
     * @return employee profile
     */
    EmployeeDTO getMyProfile(String username);

    /**
     * Update the profile of the currently logged-in employee.
     *
     * @param username authenticated username
     * @param employeeDTO updated profile
     * @return updated employee profile
     */
    EmployeeDTO updateMyProfile(String username, EmployeeDTO employeeDTO);
}