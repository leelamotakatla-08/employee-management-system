package com.example.employee_management_system.service;

import com.example.employee_management_system.dto.AttendanceDTO;

import java.util.List;

public interface AttendanceService {

    AttendanceDTO createAttendance(AttendanceDTO AttendanceDTO);

    AttendanceDTO getAttendanceById(Long attendanceId);

    List<AttendanceDTO> getAllAttendance();

    AttendanceDTO updateAttendance(Long attendanceId, AttendanceDTO AttendanceDTO);

    void deleteAttendance(Long attendanceId);

}
