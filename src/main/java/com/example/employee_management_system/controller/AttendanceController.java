package com.example.employee_management_system.controller;

import com.example.employee_management_system.dto.AttendanceDTO;
import com.example.employee_management_system.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    @PostMapping
    public ResponseEntity<AttendanceDTO> createAttendance(@RequestBody AttendanceDTO AttendanceDTO) {

        AttendanceDTO savedAttendance = attendanceService.createAttendance(AttendanceDTO);

        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<AttendanceDTO> getAttendanceById(@PathVariable Long id) {

        AttendanceDTO AttendanceDTO = attendanceService.getAttendanceById(id);

        return ResponseEntity.ok(AttendanceDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    @GetMapping
    public ResponseEntity<List<AttendanceDTO>> getAllAttendance() {

        List<AttendanceDTO> attendanceList = attendanceService.getAllAttendance();

        return ResponseEntity.ok(attendanceList);
    }

    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    @PutMapping("/{id}")
    public ResponseEntity<AttendanceDTO> updateAttendance(
            @PathVariable Long id,
            @RequestBody AttendanceDTO AttendanceDTO) {

        AttendanceDTO updatedAttendance =
                attendanceService.updateAttendance(id, AttendanceDTO);

        return ResponseEntity.ok(updatedAttendance);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAttendance(@PathVariable Long id) {

        attendanceService.deleteAttendance(id);

        return ResponseEntity.ok("Attendance deleted successfully.");
    }

}
