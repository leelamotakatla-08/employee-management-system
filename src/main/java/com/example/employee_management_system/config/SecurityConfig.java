package com.example.employee_management_system.config;

import com.example.employee_management_system.security.JwtFilter;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                // Disable CSRF because we use JWT
                .csrf(csrf -> csrf.disable())

                // Stateless Session
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(auth -> auth

                        // ============================
                        // Public Endpoints
                        // ============================
                        .requestMatchers(
                                "/",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/auth/**"
                        ).permitAll()

                        // ============================
                        // Employee Profile
                        // ============================
                        .requestMatchers(
                                "/api/employee/profile/**"
                        ).hasRole("EMPLOYEE")

                        // ============================
                        // Create Employee
                        // ============================
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/employees"
                        ).hasAnyRole("ADMIN", "HR")

                        // ============================
                        // Update Employee
                        // ============================
                        .requestMatchers(
                                HttpMethod.PUT,
                                "/api/employees/**"
                        ).hasAnyRole("ADMIN", "HR")

                        // ============================
                        // Delete Employee
                        // ============================
                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/employees/**"
                        ).hasRole("ADMIN")

                        // ============================
                        // View Employees
                        // ============================
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/employees/**"
                        ).hasAnyRole(
                                "ADMIN",
                                "HR",
                                "EMPLOYEE"
                        )

                        // ============================
                        // Remaining APIs
                        // ============================
                        .anyRequest()
                        .authenticated()
                )

                // JWT Filter
                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}