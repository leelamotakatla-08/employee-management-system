package com.example.employee_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequest {


    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50,
            message = "First name must contain 2-50 characters")
    private String firstName;



    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50,
            message = "Last name must contain 2-50 characters")
    private String lastName;



    @NotBlank(message = "Employee code is required")
    private String employeeCode;



    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;



    @NotBlank(message = "Phone number is required")
    @Size(min = 10, max = 10,
            message = "Phone number must contain 10 digits")
    private String phone;



    @NotNull(message = "Department is required")
    private Long departmentId;



    @NotBlank(message = "Designation is required")
    private String designation;



    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private BigDecimal salary;



    private LocalDate joiningDate;

}
