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

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {


    private final LeaveRepository leaveRepository;

    private final EmployeeRepository employeeRepository;


    @Override
    public LeaveDTO createLeave(LeaveDTO dto) {

        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));

        Leave leave = LeaveMapper.mapToEntity(dto, employee);

        if (leave.getStatus() == null) {
            leave.setStatus(LeaveStatus.PENDING);
        }

        return LeaveMapper.mapToDto(
                leaveRepository.save(leave)
        );
    }


    @Override
    public List<LeaveDTO> getAllLeaves() {

        return leaveRepository.findAll()
                .stream()
                .map(LeaveMapper::mapToDto)
                .toList();
    }


    @Override
    public LeaveDTO getLeaveById(Long id) {

        Leave leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave not found"));

        return LeaveMapper.mapToDto(leave);
    }


    @Override
    public LeaveDTO updateLeave(Long id, LeaveDTO dto) {

        Leave leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave not found"));


        leave.setLeaveType(dto.getLeaveType());
        leave.setStartDate(dto.getStartDate());
        leave.setEndDate(dto.getEndDate());
        leave.setReason(dto.getReason());


        return LeaveMapper.mapToDto(
                leaveRepository.save(leave)
        );
    }


    @Override
    public void deleteLeave(Long id) {

        Leave leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave not found"));

        leaveRepository.delete(leave);
    }


    @Override
    public LeaveDTO approveLeave(Long id) {

        Leave leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave not found"));

        leave.setStatus(LeaveStatus.APPROVED);


        return LeaveMapper.mapToDto(
                leaveRepository.save(leave)
        );
    }


    @Override
    public LeaveDTO rejectLeave(Long id) {

        Leave leave = leaveRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave not found"));

        leave.setStatus(LeaveStatus.REJECTED);


        return LeaveMapper.mapToDto(
                leaveRepository.save(leave)
        );
    }

}
