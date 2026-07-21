package com.example.employee_management_system.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayrollResponse {

    private Long id;

    private Long employeeId;

    private String employeeName;

    private BigDecimal basicSalary;

    private BigDecimal bonus;

    private BigDecimal deductions;

    private BigDecimal netSalary;

    private String month;
}
