package com.example.employee_management_system.dto;

import com.example.employee_management_system.entity.AttendanceStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceDTO {

    private Long id;

    private Long employeeId;

    private LocalDate date;

    private LocalTime checkIn;

    private LocalTime checkOut;

    private AttendanceStatus status;

}
