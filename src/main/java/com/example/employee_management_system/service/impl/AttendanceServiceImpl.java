package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.dto.AttendanceDTO;
import com.example.employee_management_system.entity.Attendance;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.exception.ResourceNotFoundException;
import com.example.employee_management_system.mapper.AttendanceMapper;
import com.example.employee_management_system.repository.AttendanceRepository;
import com.example.employee_management_system.repository.EmployeeRepository;
import com.example.employee_management_system.service.AttendanceService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public AttendanceDTO createAttendance(AttendanceDTO dto) {

        Employee employee = findEmployee(dto.getEmployeeId());

        Attendance attendance = AttendanceMapper.mapToAttendance(dto, employee);

        Attendance savedAttendance = attendanceRepository.save(attendance);

        return AttendanceMapper.mapToAttendanceDTO(savedAttendance);
    }

    @Override
    @Transactional(readOnly = true)
    public AttendanceDTO getAttendanceById(Long attendanceId) {

        return AttendanceMapper.mapToAttendanceDTO(
                findAttendance(attendanceId)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<AttendanceDTO> getAllAttendance() {

        return attendanceRepository.findAll()
                .stream()
                .map(AttendanceMapper::mapToAttendanceDTO)
                .toList();
    }

    @Override
    public AttendanceDTO updateAttendance(Long attendanceId, AttendanceDTO dto) {

        Attendance attendance = findAttendance(attendanceId);

        Employee employee = findEmployee(dto.getEmployeeId());

        attendance.setEmployee(employee);
        attendance.setDate(dto.getDate());
        attendance.setCheckIn(dto.getCheckIn());
        attendance.setCheckOut(dto.getCheckOut());
        attendance.setStatus(dto.getStatus());

        Attendance updatedAttendance = attendanceRepository.save(attendance);

        return AttendanceMapper.mapToAttendanceDTO(updatedAttendance);
    }

    @Override
    public void deleteAttendance(Long attendanceId) {

        attendanceRepository.delete(findAttendance(attendanceId));
    }

    // =====================================================
    // Helper Methods
    // =====================================================

    private Attendance findAttendance(Long attendanceId) {

        return attendanceRepository.findById(attendanceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Attendance not found with id: " + attendanceId
                        ));
    }

    private Employee findEmployee(Long employeeId) {

        return employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id: " + employeeId
                        ));
    }
}