package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.dto.EmployeeDTO;
import com.example.employee_management_system.entity.Department;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.entity.User;
import com.example.employee_management_system.exception.DuplicateResourceException;
import com.example.employee_management_system.exception.ResourceNotFoundException;
import com.example.employee_management_system.repository.DepartmentRepository;
import com.example.employee_management_system.repository.EmployeeRepository;
import com.example.employee_management_system.repository.UserRepository;
import com.example.employee_management_system.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {

        // Check duplicate employee email
        if (employeeRepository.findByEmail(dto.getEmail()).isPresent()) {

            throw new DuplicateResourceException(
                    "Employee email already exists"
            );
        }


        // Check duplicate employee code
        if (employeeRepository.findByEmployeeCode(dto.getEmployeeCode()).isPresent()) {

            throw new DuplicateResourceException(
                    "Employee code already exists"
            );
        }


        Department department =
                departmentRepository
                        .findByDepartmentName(dto.getDepartment())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Department not found"
                                )
                        );


        // User is optional
        User user =
                userRepository
                        .findByEmail(dto.getEmail())
                        .orElse(null);


        Employee employee = Employee.builder()
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


        return convertToDTO(
                employeeRepository.save(employee)
        );
    }



    @Override
    public List<EmployeeDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

    }



    @Override
    public EmployeeDTO getEmployeeById(Long id) {


        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found with id: " + id
                                )
                        );


        return convertToDTO(employee);

    }



    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {


        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found with id: " + id
                                )
                        );


        Department department =
                departmentRepository
                        .findByDepartmentName(dto.getDepartment())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Department not found"
                                )
                        );


        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setDepartment(department);
        employee.setDesignation(dto.getDesignation());
        employee.setSalary(dto.getSalary());
        employee.setJoiningDate(dto.getJoiningDate());


        return convertToDTO(
                employeeRepository.save(employee)
        );

    }



    @Override
    public void deleteEmployee(Long id) {


        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found with id: " + id
                                )
                        );


        employeeRepository.delete(employee);

    }



    @Override
    public EmployeeDTO getMyProfile(String username) {


        Employee employee =
                employeeRepository.findByUserUsername(username)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee profile not found"
                                )
                        );


        return convertToDTO(employee);

    }



    @Override
    public EmployeeDTO updateMyProfile(
            String username,
            EmployeeDTO dto) {


        Employee employee =
                employeeRepository.findByUserUsername(username)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee profile not found"
                                )
                        );


        employee.setPhone(dto.getPhone());
        employee.setDesignation(dto.getDesignation());


        return convertToDTO(
                employeeRepository.save(employee)
        );

    }



    private EmployeeDTO convertToDTO(Employee employee) {


        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .employeeCode(employee.getEmployeeCode())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .department(
                        employee.getDepartment()
                                .getDepartmentName()
                )
                .designation(employee.getDesignation())
                .salary(employee.getSalary())
                .joiningDate(employee.getJoiningDate())
                .build();

    }

}
