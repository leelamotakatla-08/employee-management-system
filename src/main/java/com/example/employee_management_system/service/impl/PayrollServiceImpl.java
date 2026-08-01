package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.dto.PayrollRequest;
import com.example.employee_management_system.dto.PayrollResponse;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.entity.Payroll;
import com.example.employee_management_system.exception.ResourceNotFoundException;
import com.example.employee_management_system.mapper.PayrollMapper;
import com.example.employee_management_system.repository.EmployeeRepository;
import com.example.employee_management_system.repository.PayrollRepository;
import com.example.employee_management_system.service.PayrollService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository payrollRepository;

    private final EmployeeRepository employeeRepository;

    @Override
    public PayrollResponse createPayroll(PayrollRequest request) {

        Employee employee = findEmployee(request.getEmployeeId());

        Payroll payroll = PayrollMapper.mapToEntity(request, employee);

        Payroll savedPayroll = payrollRepository.save(payroll);

        return PayrollMapper.mapToResponse(savedPayroll);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PayrollResponse> getAllPayrolls() {

        return payrollRepository.findAll()
                .stream()
                .map(PayrollMapper::mapToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PayrollResponse getPayrollById(Long id) {

        return PayrollMapper.mapToResponse(findPayroll(id));
    }

    @Override
    public PayrollResponse updatePayroll(Long id, PayrollRequest request) {

        Payroll payroll = findPayroll(id);

        Employee employee = findEmployee(request.getEmployeeId());

        PayrollMapper.updateEntity(payroll, request, employee);

        Payroll updatedPayroll = payrollRepository.save(payroll);

        return PayrollMapper.mapToResponse(updatedPayroll);
    }

    @Override
    public void deletePayroll(Long id) {

        payrollRepository.delete(findPayroll(id));
    }

    // =====================================================
    // Helper Methods
    // =====================================================

    private Payroll findPayroll(Long id) {

        return payrollRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Payroll not found with id: " + id
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