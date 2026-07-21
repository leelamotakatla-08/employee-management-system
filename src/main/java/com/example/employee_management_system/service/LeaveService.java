package com.example.employee_management_system.service;

import com.example.employee_management_system.dto.LeaveDTO;

import java.util.List;

public interface LeaveService {

    LeaveDTO createLeave(LeaveDTO dto);

    List<LeaveDTO> getAllLeaves();

    LeaveDTO getLeaveById(Long id);

    LeaveDTO updateLeave(Long id, LeaveDTO dto);

    void deleteLeave(Long id);

    LeaveDTO approveLeave(Long id);

    LeaveDTO rejectLeave(Long id);

}
