package com.example.employee_management_system.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String employeeCode;

    private String email;

    private String phone;

    private Long departmentId;

    private String departmentName;

    private String designation;

    private BigDecimal salary;

    private LocalDate joiningDate;

}
