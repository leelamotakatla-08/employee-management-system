package com.example.employee_management_system.mapper;

import com.example.employee_management_system.dto.PayrollRequest;
import com.example.employee_management_system.dto.PayrollResponse;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.entity.Payroll;

import java.math.BigDecimal;

/**
 * Mapper class for Payroll Entity and DTO conversion.
 */
public final class PayrollMapper {

    private PayrollMapper() {
        // Prevent instantiation
    }

    /**
     * Calculate Net Salary.
     */
    public static BigDecimal calculateNetSalary(
            BigDecimal basicSalary,
            BigDecimal bonus,
            BigDecimal deductions
    ) {

        if (basicSalary == null) {
            basicSalary = BigDecimal.ZERO;
        }

        if (bonus == null) {
            bonus = BigDecimal.ZERO;
        }

        if (deductions == null) {
            deductions = BigDecimal.ZERO;
        }

        return basicSalary
                .add(bonus)
                .subtract(deductions);
    }

    /**
     * Convert PayrollRequest to Payroll Entity.
     */
    public static Payroll mapToEntity(
            PayrollRequest request,
            Employee employee
    ) {

        return Payroll.builder()
                .employee(employee)
                .basicSalary(request.getBasicSalary())
                .bonus(request.getBonus())
                .deductions(request.getDeductions())
                .netSalary(
                        calculateNetSalary(
                                request.getBasicSalary(),
                                request.getBonus(),
                                request.getDeductions()
                        )
                )
                .month(request.getMonth())
                .build();
    }

    /**
     * Convert Payroll Entity to PayrollResponse.
     */
    public static PayrollResponse mapToResponse(Payroll payroll) {

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

    /**
     * Update an existing Payroll entity.
     */
    public static void updateEntity(
            Payroll payroll,
            PayrollRequest request,
            Employee employee
    ) {

        payroll.setEmployee(employee);
        payroll.setBasicSalary(request.getBasicSalary());
        payroll.setBonus(request.getBonus());
        payroll.setDeductions(request.getDeductions());
        payroll.setNetSalary(
                calculateNetSalary(
                        request.getBasicSalary(),
                        request.getBonus(),
                        request.getDeductions()
                )
        );
        payroll.setMonth(request.getMonth());
    }
}