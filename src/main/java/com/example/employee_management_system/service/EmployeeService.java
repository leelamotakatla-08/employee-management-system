package com.example.employee_management_system.service;

import com.example.employee_management_system.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    // CREATE EMPLOYEE
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    // GET ALL EMPLOYEES
    List<EmployeeDTO> getAllEmployees();

    // GET EMPLOYEE BY ID
    EmployeeDTO getEmployeeById(Long id);

    // UPDATE EMPLOYEE
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    // DELETE EMPLOYEE
    void deleteEmployee(Long id);

    // GET LOGGED-IN EMPLOYEE PROFILE
    EmployeeDTO getMyProfile(String username);

    // UPDATE LOGGED-IN EMPLOYEE PROFILE
    EmployeeDTO updateMyProfile(String username, EmployeeDTO employeeDTO);

}
