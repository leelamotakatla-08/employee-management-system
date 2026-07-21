package com.example.employee_management_system.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayrollRequest {

    private Long employeeId;

    private BigDecimal basicSalary;

    private BigDecimal bonus;

    private BigDecimal deductions;

    private String month;
}
