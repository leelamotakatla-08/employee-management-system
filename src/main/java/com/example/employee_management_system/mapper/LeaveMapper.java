package com.example.employee_management_system.mapper;

import com.example.employee_management_system.dto.LeaveDTO;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.entity.Leave;

public class LeaveMapper {


    public static LeaveDTO mapToDto(Leave leave){

        return LeaveDTO.builder()
                .id(leave.getId())
                .employeeId(leave.getEmployee().getId())
                .leaveType(leave.getLeaveType())
                .startDate(leave.getStartDate())
                .endDate(leave.getEndDate())
                .reason(leave.getReason())
                .status(leave.getStatus())
                .build();

    }


    public static Leave mapToEntity(LeaveDTO dto, Employee employee){

        return Leave.builder()
                .id(dto.getId())
                .employee(employee)
                .leaveType(dto.getLeaveType())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .reason(dto.getReason())
                .status(dto.getStatus())
                .build();

    }

}
