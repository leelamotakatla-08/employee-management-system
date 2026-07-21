package com.example.employee_management_system.dto;

import com.example.employee_management_system.entity.LeaveStatus;
import com.example.employee_management_system.entity.LeaveType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveDTO {

    private Long id;

    private Long employeeId;

    private LeaveType leaveType;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private LeaveStatus status;

}
