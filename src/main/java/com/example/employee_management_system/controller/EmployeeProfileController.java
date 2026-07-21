package com.example.employee_management_system.controller;

import com.example.employee_management_system.dto.EmployeeDTO;
import com.example.employee_management_system.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee/profile")
@RequiredArgsConstructor
public class EmployeeProfileController {

    private final EmployeeService employeeService;


    // GET MY PROFILE
    @GetMapping
    public ResponseEntity<EmployeeDTO> getMyProfile(
            Authentication authentication) {

        String username = authentication.getName();

        return ResponseEntity.ok(
                employeeService.getMyProfile(username)
        );
    }


    // UPDATE MY PROFILE
    @PutMapping
    public ResponseEntity<EmployeeDTO> updateMyProfile(
            Authentication authentication,
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        String username = authentication.getName();

        return ResponseEntity.ok(
                employeeService.updateMyProfile(
                        username,
                        employeeDTO
                )
        );
    }

}
