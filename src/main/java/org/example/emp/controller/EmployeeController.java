package org.example.emp.controller;

import org.example.emp.dto.EmployeeDTO;
import org.example.emp.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public EmployeeDTO getEmployee(@PathVariable Long empId) {
        return employeeService.getEmployee(empId);
    }
}
