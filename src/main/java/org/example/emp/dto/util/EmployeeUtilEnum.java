package org.example.emp.dto.util;

import org.example.emp.dto.EmployeeDTO;
import org.example.emp.dto.ManagerDTO;
import org.example.emp.model.Employee;
import org.example.emp.model.Manager;

import java.util.List;

public enum EmployeeUtilEnum {
    EMPLOYEE_UTIL;

    public EmployeeDTO build(Employee emp) {
        Manager mgr = emp.getManager();
        return org.example.emp.dto.EmployeeDTO.builder()
                .empId(emp.getEmpId()).empName(emp.getEmpName())
                .manager(ManagerDTO.builder()
                        .managerId(mgr.getManagerId()).managerName(mgr.getManagerName())
                        .build())
                .build();
    }

    public List<EmployeeDTO> build(List<Employee> empList) {
        return empList.stream().map(this::build).toList();
    }
}
