package com.example.employee_management_system.service;


import com.example.employee_management_system.dto.DashboardResponse;
import com.example.employee_management_system.repository.DashboardRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class DashboardService {


    private final DashboardRepository dashboardRepository;



    public DashboardResponse getDashboardData() {


        DashboardResponse response = new DashboardResponse();



        response.setTotalEmployees(
                dashboardRepository.countEmployees()
        );



        response.setTotalDepartments(
                dashboardRepository.countDepartments()
        );



        response.setEmployeesOnLeave(
                dashboardRepository.countEmployeesOnLeave()
        );



        response.setPresentToday(
                dashboardRepository.countPresentToday()
        );



        response.setTotalSalaryPaid(
                dashboardRepository.totalSalaryPaid()
        );



        response.setAverageSalary(
                dashboardRepository.averageSalary()
        );



        return response;

    }

}
