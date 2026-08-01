package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.dto.DepartmentRequest;
import com.example.employee_management_system.dto.DepartmentResponse;
import com.example.employee_management_system.entity.Department;
import com.example.employee_management_system.exception.DuplicateResourceException;
import com.example.employee_management_system.exception.ResourceNotFoundException;
import com.example.employee_management_system.mapper.DepartmentMapper;
import com.example.employee_management_system.repository.DepartmentRepository;
import com.example.employee_management_system.service.DepartmentService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {

        validateDuplicateDepartment(request);

        Department department = DepartmentMapper.mapToEntity(request);

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToResponse(savedDepartment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentResponse> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::mapToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentResponse getDepartmentById(Long id) {

        return DepartmentMapper.mapToResponse(findDepartment(id));
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentRequest request) {

        Department department = findDepartment(id);

        departmentRepository.findByDepartmentName(request.getDepartmentName())
                .filter(d -> !d.getId().equals(id))
                .ifPresent(d -> {
                    throw new DuplicateResourceException(
                            "Department name already exists."
                    );
                });

        DepartmentMapper.updateEntity(department, request);

        Department updatedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToResponse(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {

        departmentRepository.delete(findDepartment(id));
    }

    // =====================================================
    // Helper Methods
    // =====================================================

    private Department findDepartment(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found with id: " + id
                        ));
    }

    private void validateDuplicateDepartment(DepartmentRequest request) {

        if (departmentRepository.findByDepartmentName(request.getDepartmentName()).isPresent()) {
            throw new DuplicateResourceException(
                    "Department name already exists."
            );
        }

        if (departmentRepository.findByDepartmentCode(request.getDepartmentCode()).isPresent()) {
            throw new DuplicateResourceException(
                    "Department code already exists."
            );
        }
    }
}