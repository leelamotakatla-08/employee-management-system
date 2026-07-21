package com.example.employee_management_system.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("\n================ JWT FILTER ================");
        System.out.println("Request URI : " + request.getRequestURI());

        String path = request.getServletPath();

        // Skip authentication for login/register
        if (path.equals("/auth/login") || path.equals("/auth/register")) {
            System.out.println("Skipping JWT for: " + path);
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        System.out.println("Authorization Header: " + authHeader);

        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            token = authHeader.substring(7);

            System.out.println("JWT Token: " + token);

            if (jwtUtil.validateToken(token)) {

                System.out.println("Token is VALID");

                username = jwtUtil.extractUsername(token);

                System.out.println("Username from Token: " + username);

            } else {

                System.out.println("Token is INVALID");
            }

        } else {

            System.out.println("Authorization header missing or invalid.");
        }

        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(username);

            System.out.println("User Loaded: " + userDetails.getUsername());
            System.out.println("Authorities: " + userDetails.getAuthorities());

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities());

            authentication.setDetails(
                    new WebAuthenticationDetailsSource()
                            .buildDetails(request));

            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);

            System.out.println("Authentication SUCCESS");
        } else {

            System.out.println("Authentication NOT set.");
        }

        System.out.println("============================================\n");

        filterChain.doFilter(request, response);
    }
}
