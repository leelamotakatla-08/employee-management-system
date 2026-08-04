package com.example.employee_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {

    private long totalEmployees;

    private long totalDepartments;

    private long employeesOnLeave;

    private long presentToday;

    private double totalSalaryPaid;

    private double averageSalary;

}