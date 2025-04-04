package org.example.emp.service;

import lombok.extern.slf4j.Slf4j;
import org.example.emp.dto.EmployeeDTO;
import org.example.emp.model.Employee;
import org.example.emp.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.example.emp.dto.util.EmployeeUtilEnum.EMPLOYEE_UTIL;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    public List<EmployeeDTO> getAllEmployees() {
        return EMPLOYEE_UTIL.build(empRepo.findAll());
    }

    public EmployeeDTO getEmployee(Long empId) {
        Optional<Employee> optEmployee = empRepo.findById(empId);
        if (optEmployee.isPresent()) {
            return EMPLOYEE_UTIL.build(optEmployee.get());
        }
        return EmployeeDTO.builder().build();
    }

    public void saveEmployees(List<Employee> employees) {
        empRepo.saveAll(employees);
        log.info("All employees got saved");
    }
}
