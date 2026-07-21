package com.example.employee_management_system.controller;

import com.example.employee_management_system.dto.AuthResponse;
import com.example.employee_management_system.dto.LoginRequest;
import com.example.employee_management_system.dto.RegisterRequest;
import com.example.employee_management_system.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }


    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        System.out.println("========== LOGIN API CALLED ==========");
        System.out.println("USERNAME : " + request.getUsername());
        System.out.println("PASSWORD : " + request.getPassword());

        return authService.login(request);
    }
}
