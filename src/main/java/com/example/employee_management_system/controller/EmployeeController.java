package com.example.employee_management_system.controller;

import com.example.employee_management_system.dto.EmployeeDTO;
import com.example.employee_management_system.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "Employee Management",
        description = "APIs for managing employees"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Create Employee
     */
    @Operation(summary = "Create a new employee")
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public ResponseEntity<EmployeeDTO> createEmployee(
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        log.info("Creating employee: {}", employeeDTO.getEmail());

        EmployeeDTO savedEmployee =
                employeeService.createEmployee(employeeDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }

    /**
     * Get All Employees
     */
    @Operation(summary = "Get all employees")
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {

        log.info("Fetching all employees");

        return ResponseEntity.ok(
                employeeService.getAllEmployees()
        );
    }

    /**
     * Get Employee By ID
     */
    @Operation(summary = "Get employee by ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    public ResponseEntity<EmployeeDTO> getEmployeeById(
            @PathVariable Long id) {

        log.info("Fetching employee with ID {}", id);

        return ResponseEntity.ok(
                employeeService.getEmployeeById(id)
        );
    }

    /**
     * Update Employee
     */
    @Operation(summary = "Update employee")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        log.info("Updating employee with ID {}", id);

        return ResponseEntity.ok(
                employeeService.updateEmployee(id, employeeDTO)
        );
    }

    /**
     * Delete Employee
     */
    @Operation(summary = "Delete employee")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id) {

        log.info("Deleting employee with ID {}", id);

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(
                "Employee deleted successfully."
        );
    }
}