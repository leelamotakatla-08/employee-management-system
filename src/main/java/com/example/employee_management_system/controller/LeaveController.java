package com.example.employee_management_system.controller;


import com.example.employee_management_system.dto.LeaveDTO;
import com.example.employee_management_system.service.LeaveService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
public class LeaveController {


    private final LeaveService leaveService;


    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    public ResponseEntity<LeaveDTO> createLeave(
            @RequestBody LeaveDTO dto) {

        return new ResponseEntity<>(
                leaveService.createLeave(dto),
                HttpStatus.CREATED
        );
    }


    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public ResponseEntity<List<LeaveDTO>> getAllLeaves() {

        return ResponseEntity.ok(
                leaveService.getAllLeaves()
        );
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    public ResponseEntity<LeaveDTO> getLeaveById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                leaveService.getLeaveById(id)
        );
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public ResponseEntity<LeaveDTO> updateLeave(
            @PathVariable Long id,
            @RequestBody LeaveDTO dto) {

        return ResponseEntity.ok(
                leaveService.updateLeave(id, dto)
        );
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteLeave(
            @PathVariable Long id) {

        leaveService.deleteLeave(id);

        return ResponseEntity.ok(
                "Leave deleted successfully"
        );
    }


    @PutMapping("/{id}/approve")
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public ResponseEntity<LeaveDTO> approveLeave(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                leaveService.approveLeave(id)
        );
    }


    @PutMapping("/{id}/reject")
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public ResponseEntity<LeaveDTO> rejectLeave(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                leaveService.rejectLeave(id)
        );
    }

}
