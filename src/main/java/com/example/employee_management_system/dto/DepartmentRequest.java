package com.example.employee_management_system.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentRequest {

    private String departmentName;

    private String departmentCode;

    private String description;

}
