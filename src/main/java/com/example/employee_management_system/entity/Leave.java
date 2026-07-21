package com.example.employee_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;


    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;


    @Enumerated(EnumType.STRING)
    private LeaveStatus status;

}
