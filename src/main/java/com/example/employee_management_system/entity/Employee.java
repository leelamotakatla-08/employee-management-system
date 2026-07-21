package com.example.employee_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String firstName;


    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false, unique = true)
    private String employeeCode;


    @Column(nullable = false, unique = true)
    private String email;


    private String phone;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    private String designation;


    private BigDecimal salary;


    private LocalDate joiningDate;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
