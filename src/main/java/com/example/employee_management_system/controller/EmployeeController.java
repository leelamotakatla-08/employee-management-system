package com.example.employee_management_system.controller;

import com.example.employee_management_system.dto.EmployeeDTO;
import com.example.employee_management_system.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // CREATE EMPLOYEE
    // ADMIN and HR
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public ResponseEntity<EmployeeDTO> createEmployee(
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        EmployeeDTO savedEmployee =
                employeeService.createEmployee(employeeDTO);

        return new ResponseEntity<>(
                savedEmployee,
                HttpStatus.CREATED
        );
    }

    // GET ALL EMPLOYEES
    // ADMIN, HR and EMPLOYEE
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {

        return ResponseEntity.ok(
                employeeService.getAllEmployees()
        );
    }

    // GET EMPLOYEE BY ID
    // ADMIN, HR and EMPLOYEE
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    public ResponseEntity<EmployeeDTO> getEmployeeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                employeeService.getEmployeeById(id)
        );
    }

    // UPDATE EMPLOYEE
    // ADMIN and HR
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(id, employeeDTO)
        );
    }

    // DELETE EMPLOYEE
    // ONLY ADMIN
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(
                "Employee deleted successfully"
        );
    }
}
