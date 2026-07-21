package com.example.employee_management_system.service;

import com.example.employee_management_system.dto.PayrollRequest;
import com.example.employee_management_system.dto.PayrollResponse;

import java.util.List;

public interface PayrollService {

    PayrollResponse createPayroll(PayrollRequest request);

    List<PayrollResponse> getAllPayrolls();

    PayrollResponse getPayrollById(Long id);

    PayrollResponse updatePayroll(Long id, PayrollRequest request);

    void deletePayroll(Long id);
}
