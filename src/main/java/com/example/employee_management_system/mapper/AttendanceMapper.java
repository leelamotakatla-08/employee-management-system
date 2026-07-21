package com.example.employee_management_system.mapper;

import com.example.employee_management_system.dto.AttendanceDTO;
import com.example.employee_management_system.entity.Attendance;
import com.example.employee_management_system.entity.Employee;

public class AttendanceMapper {

    public static AttendanceDTO mapToAttendanceDTO(Attendance attendance) {

        return AttendanceDTO.builder()
                .id(attendance.getId())
                .employeeId(attendance.getEmployee().getId())
                .date(attendance.getDate())
                .checkIn(attendance.getCheckIn())
                .checkOut(attendance.getCheckOut())
                .status(attendance.getStatus())
                .build();

    }

    public static Attendance mapToAttendance(AttendanceDTO AttendanceDTO, Employee employee) {

        return Attendance.builder()
                .id(AttendanceDTO.getId())
                .employee(employee)
                .date(AttendanceDTO.getDate())
                .checkIn(AttendanceDTO.getCheckIn())
                .checkOut(AttendanceDTO.getCheckOut())
                .status(AttendanceDTO.getStatus())
                .build();

    }

}
