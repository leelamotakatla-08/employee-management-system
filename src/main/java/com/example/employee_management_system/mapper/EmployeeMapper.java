package com.example.employee_management_system.mapper;

import com.example.employee_management_system.dto.EmployeeDTO;
import com.example.employee_management_system.entity.Department;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.entity.User;

/**
 * Mapper class for converting Employee Entity and EmployeeDTO.
 */
public final class EmployeeMapper {

    private EmployeeMapper() {
        // Prevent instantiation
    }

    /**
     * Convert Employee entity to EmployeeDTO.
     *
     * @param employee Employee entity
     * @return EmployeeDTO
     */
    public static EmployeeDTO mapToDTO(Employee employee) {

        if (employee == null) {
            return null;
        }

        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .employeeCode(employee.getEmployeeCode())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .department(
                        employee.getDepartment() != null
                                ? employee.getDepartment().getDepartmentName()
                                : null
                )
                .designation(employee.getDesignation())
                .salary(employee.getSalary())
                .joiningDate(employee.getJoiningDate())
                .build();
    }

    /**
     * Convert EmployeeDTO to Employee entity.
     *
     * @param dto EmployeeDTO
     * @param department Department entity
     * @param user User entity
     * @return Employee entity
     */
    public static Employee mapToEntity(
            EmployeeDTO dto,
            Department department,
            User user
    ) {

        if (dto == null) {
            return null;
        }

        return Employee.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .employeeCode(dto.getEmployeeCode())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .department(department)
                .designation(dto.getDesignation())
                .salary(dto.getSalary())
                .joiningDate(dto.getJoiningDate())
                .user(user)
                .build();
    }

    /**
     * Update an existing Employee entity from EmployeeDTO.
     *
     * @param employee Existing Employee
     * @param dto EmployeeDTO
     * @param department Department entity
     */
    public static void updateEntity(
            Employee employee,
            EmployeeDTO dto,
            Department department
    ) {

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setDepartment(department);
        employee.setDesignation(dto.getDesignation());
        employee.setSalary(dto.getSalary());
        employee.setJoiningDate(dto.getJoiningDate());
    }
}