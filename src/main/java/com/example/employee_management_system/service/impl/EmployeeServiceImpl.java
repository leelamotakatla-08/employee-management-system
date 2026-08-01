package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.dto.EmployeeDTO;
import com.example.employee_management_system.entity.Department;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.entity.User;
import com.example.employee_management_system.exception.DuplicateResourceException;
import com.example.employee_management_system.exception.ResourceNotFoundException;
import com.example.employee_management_system.mapper.EmployeeMapper;
import com.example.employee_management_system.repository.DepartmentRepository;
import com.example.employee_management_system.repository.EmployeeRepository;
import com.example.employee_management_system.repository.UserRepository;
import com.example.employee_management_system.service.EmployeeService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {

        validateDuplicateEmployee(dto);

        Department department = findDepartment(dto.getDepartment());

        User user = userRepository
                .findByEmail(dto.getEmail())
                .orElse(null);

        Employee employee = EmployeeMapper.mapToEntity(dto, department, user);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToDTO(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::mapToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDTO getEmployeeById(Long id) {

        return EmployeeMapper.mapToDTO(findEmployee(id));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {

        Employee employee = findEmployee(id);

        employeeRepository.findByEmail(dto.getEmail())
                .filter(e -> !e.getId().equals(id))
                .ifPresent(e -> {
                    throw new DuplicateResourceException(
                            "Employee email already exists."
                    );
                });

        Department department = findDepartment(dto.getDepartment());

        EmployeeMapper.updateEntity(employee, dto, department);

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        employeeRepository.delete(findEmployee(id));
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDTO getMyProfile(String username) {

        Employee employee = employeeRepository.findByUserUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee profile not found for user: " + username
                        ));

        return EmployeeMapper.mapToDTO(employee);
    }

    @Override
    public EmployeeDTO updateMyProfile(String username, EmployeeDTO dto) {

        Employee employee = employeeRepository.findByUserUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee profile not found for user: " + username
                        ));

        employee.setPhone(dto.getPhone());
        employee.setDesignation(dto.getDesignation());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToDTO(updatedEmployee);
    }

    // =====================================================
    // Helper Methods
    // =====================================================

    private Employee findEmployee(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with ID: " + id
                        ));
    }

    private Department findDepartment(String departmentName) {

        return departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department '" + departmentName + "' not found."
                        ));
    }

    private void validateDuplicateEmployee(EmployeeDTO dto) {

        if (employeeRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new DuplicateResourceException(
                    "Employee email already exists."
            );
        }

        if (employeeRepository.findByEmployeeCode(dto.getEmployeeCode()).isPresent()) {
            throw new DuplicateResourceException(
                    "Employee code already exists."
            );
        }
    }
}