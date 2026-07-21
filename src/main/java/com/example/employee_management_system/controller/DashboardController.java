package com.example.employee_management_system.controller;


import com.example.employee_management_system.dto.DashboardResponse;
import com.example.employee_management_system.service.DashboardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {


    private final DashboardService dashboardService;



    @GetMapping("/summary")
    public DashboardResponse getDashboardSummary(){

        return dashboardService.getDashboardData();

    }

}
