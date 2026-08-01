package com.example.employee_management_system.mapper;

import com.example.employee_management_system.dto.DepartmentRequest;
import com.example.employee_management_system.dto.DepartmentResponse;
import com.example.employee_management_system.entity.Department;

/**
 * Mapper class for Department Entity and DTO conversion.
 */
public final class DepartmentMapper {

    private DepartmentMapper() {
        // Prevent instantiation
    }

    /**
     * Convert DepartmentRequest to Department Entity.
     *
     * @param request Department request DTO
     * @return Department entity
     */
    public static Department mapToEntity(DepartmentRequest request) {

        if (request == null) {
            return null;
        }

        return Department.builder()
                .departmentName(request.getDepartmentName())
                .departmentCode(request.getDepartmentCode())
                .description(request.getDescription())
                .build();
    }

    /**
     * Convert Department Entity to DepartmentResponse.
     *
     * @param department Department entity
     * @return Department response DTO
     */
    public static DepartmentResponse mapToResponse(Department department) {

        if (department == null) {
            return null;
        }

        return DepartmentResponse.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentCode(department.getDepartmentCode())
                .description(department.getDescription())
                .build();
    }

    /**
     * Update an existing Department entity.
     *
     * @param department Existing department entity
     * @param request Updated department request
     */
    public static void updateEntity(
            Department department,
            DepartmentRequest request
    ) {

        department.setDepartmentName(request.getDepartmentName());
        department.setDepartmentCode(request.getDepartmentCode());
        department.setDescription(request.getDescription());
    }
}