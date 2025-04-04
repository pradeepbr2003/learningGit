package org.example.emp.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeDTO {
    private Long empId;
    private String empName;
    private ManagerDTO manager;
}
