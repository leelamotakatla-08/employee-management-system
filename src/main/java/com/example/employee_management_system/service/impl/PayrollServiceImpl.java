package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.dto.PayrollRequest;
import com.example.employee_management_system.dto.PayrollResponse;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.entity.Payroll;
import com.example.employee_management_system.exception.ResourceNotFoundException;
import com.example.employee_management_system.repository.EmployeeRepository;
import com.example.employee_management_system.repository.PayrollRepository;
import com.example.employee_management_system.service.PayrollService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {


    private final PayrollRepository payrollRepository;

    private final EmployeeRepository employeeRepository;



    @Override
    public PayrollResponse createPayroll(PayrollRequest request) {


        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));



        BigDecimal netSalary =
                request.getBasicSalary()
                        .add(request.getBonus())
                        .subtract(request.getDeductions());



        Payroll payroll = Payroll.builder()

                .employee(employee)
                .basicSalary(request.getBasicSalary())
                .bonus(request.getBonus())
                .deductions(request.getDeductions())
                .netSalary(netSalary)
                .month(request.getMonth())

                .build();



        Payroll savedPayroll = payrollRepository.save(payroll);


        return mapToResponse(savedPayroll);
    }





    @Override
    public List<PayrollResponse> getAllPayrolls() {

        return payrollRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }





    @Override
    public PayrollResponse getPayrollById(Long id) {


        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Payroll not found"));


        return mapToResponse(payroll);
    }





    @Override
    public PayrollResponse updatePayroll(Long id, PayrollRequest request) {


        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Payroll not found"));



        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));



        BigDecimal netSalary =
                request.getBasicSalary()
                        .add(request.getBonus())
                        .subtract(request.getDeductions());



        payroll.setEmployee(employee);
        payroll.setBasicSalary(request.getBasicSalary());
        payroll.setBonus(request.getBonus());
        payroll.setDeductions(request.getDeductions());
        payroll.setNetSalary(netSalary);
        payroll.setMonth(request.getMonth());



        Payroll updatedPayroll =
                payrollRepository.save(payroll);



        return mapToResponse(updatedPayroll);
    }





    @Override
    public void deletePayroll(Long id) {


        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Payroll not found"));


        payrollRepository.delete(payroll);

    }





    private PayrollResponse mapToResponse(Payroll payroll) {


        return PayrollResponse.builder()

                .id(payroll.getId())

                .employeeId(payroll.getEmployee().getId())

                .employeeName(
                        payroll.getEmployee().getFirstName()
                                + " "
                                + payroll.getEmployee().getLastName()
                )

                .basicSalary(payroll.getBasicSalary())

                .bonus(payroll.getBonus())

                .deductions(payroll.getDeductions())

                .netSalary(payroll.getNetSalary())

                .month(payroll.getMonth())

                .build();
    }

}
