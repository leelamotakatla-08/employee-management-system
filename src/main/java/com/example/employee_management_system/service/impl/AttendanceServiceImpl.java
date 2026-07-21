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

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public AttendanceDTO createAttendance(AttendanceDTO AttendanceDTO) {

        Employee employee = employeeRepository.findById(AttendanceDTO.getEmployeeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: "
                                + AttendanceDTO.getEmployeeId()));

        Attendance attendance = AttendanceMapper.mapToAttendance(AttendanceDTO, employee);

        Attendance savedAttendance = attendanceRepository.save(attendance);

        return AttendanceMapper.mapToAttendanceDTO(savedAttendance);
    }

    @Override
    public AttendanceDTO getAttendanceById(Long attendanceId) {

        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Attendance not found with id: "
                                + attendanceId));

        return AttendanceMapper.mapToAttendanceDTO(attendance);
    }

    @Override
    public List<AttendanceDTO> getAllAttendance() {

        List<Attendance> attendanceList = attendanceRepository.findAll();

        return attendanceList.stream()
                .map(AttendanceMapper::mapToAttendanceDTO)
                .toList();
    }

    @Override
    public AttendanceDTO updateAttendance(Long attendanceId, AttendanceDTO AttendanceDTO) {

        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Attendance not found with id: "
                                + attendanceId));

        Employee employee = employeeRepository.findById(AttendanceDTO.getEmployeeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: "
                                + AttendanceDTO.getEmployeeId()));

        attendance.setEmployee(employee);
        attendance.setDate(AttendanceDTO.getDate());
        attendance.setCheckIn(AttendanceDTO.getCheckIn());
        attendance.setCheckOut(AttendanceDTO.getCheckOut());
        attendance.setStatus(AttendanceDTO.getStatus());

        Attendance updatedAttendance = attendanceRepository.save(attendance);

        return AttendanceMapper.mapToAttendanceDTO(updatedAttendance);
    }

    @Override
    public void deleteAttendance(Long attendanceId) {

        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Attendance not found with id: "
                                + attendanceId));

        attendanceRepository.delete(attendance);
    }
}
