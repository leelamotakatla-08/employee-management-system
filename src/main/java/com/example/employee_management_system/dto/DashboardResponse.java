package com.example.employee_management_system.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {


    private long totalEmployees;


    private long totalDepartments;


    private long employeesOnLeave;


    private long presentToday;


    private double totalSalaryPaid;


    private double averageSalary;


}
