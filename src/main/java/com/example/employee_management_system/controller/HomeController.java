package com.example.employee_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
                ===========================================
                Employee Management System API
                ===========================================

                Application Status : RUNNING

                Swagger UI:
                /swagger-ui/index.html

                API Docs:
                /v3/api-docs

                GitHub:
                https://github.com/leelamotakatla-08/employee-management-system
                """;
    }
}