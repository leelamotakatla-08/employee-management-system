package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.dto.LeaveDTO;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.entity.Leave;
import com.example.employee_management_system.entity.LeaveStatus;
import com.example.employee_management_system.exception.ResourceNotFoundException;
import com.example.employee_management_system.mapper.LeaveMapper;
import com.example.employee_management_system.repository.EmployeeRepository;
import com.example.employee_management_system.repository.LeaveRepository;
import com.example.employee_management_system.service.LeaveService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    private final EmployeeRepository employeeRepository;

    @Override
    public LeaveDTO createLeave(LeaveDTO dto) {

        Employee employee = findEmployee(dto.getEmployeeId());

        Leave leave = LeaveMapper.mapToEntity(dto, employee);

        if (leave.getStatus() == null) {
            leave.setStatus(LeaveStatus.PENDING);
        }

        Leave savedLeave = leaveRepository.save(leave);

        return LeaveMapper.mapToDto(savedLeave);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LeaveDTO> getAllLeaves() {

        return leaveRepository.findAll()
                .stream()
                .map(LeaveMapper::mapToDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public LeaveDTO getLeaveById(Long id) {

        return LeaveMapper.mapToDto(findLeave(id));
    }

    @Override
    public LeaveDTO updateLeave(Long id, LeaveDTO dto) {

        Leave leave = findLeave(id);

        leave.setLeaveType(dto.getLeaveType());
        leave.setStartDate(dto.getStartDate());
        leave.setEndDate(dto.getEndDate());
        leave.setReason(dto.getReason());

        Leave updatedLeave = leaveRepository.save(leave);

        return LeaveMapper.mapToDto(updatedLeave);
    }

    @Override
    public void deleteLeave(Long id) {

        leaveRepository.delete(findLeave(id));
    }

    @Override
    public LeaveDTO approveLeave(Long id) {

        Leave leave = findLeave(id);

        leave.setStatus(LeaveStatus.APPROVED);

        Leave updatedLeave = leaveRepository.save(leave);

        return LeaveMapper.mapToDto(updatedLeave);
    }

    @Override
    public LeaveDTO rejectLeave(Long id) {

        Leave leave = findLeave(id);

        leave.setStatus(LeaveStatus.REJECTED);

        Leave updatedLeave = leaveRepository.save(leave);

        return LeaveMapper.mapToDto(updatedLeave);
    }

    // =====================================================
    // Helper Methods
    // =====================================================

    private Leave findLeave(Long id) {

        return leaveRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Leave not found with id: " + id
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