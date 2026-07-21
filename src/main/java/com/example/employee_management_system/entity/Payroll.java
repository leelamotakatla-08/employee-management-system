package com.example.employee_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payrolls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    private BigDecimal basicSalary;

    private BigDecimal bonus;

    private BigDecimal deductions;

    private BigDecimal netSalary;

    private String month;
}
