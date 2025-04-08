package org.example.emp.provider;

import org.example.common.config.UserConfiguration;
import org.example.emp.model.Employee;
import org.example.emp.model.Manager;
import org.example.emp.service.EmployeeService;
import org.example.emp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class EmployeeProvider {

    @Autowired
    private EmployeeService empService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserConfiguration config;


    @Bean
    public List<Employee> employees() {
        Random random = new Random();
        List<Manager> managers = IntStream.range(config.getUsername().length / 2, config.getUsername().length)
                .mapToObj(i ->
                        Manager.builder().managerId(96l + i).managerName(config.getUsername()[i]).build()).toList();
        managerService.saveManager(managers);

        List<Employee> employees = IntStream.range(0, config.getUsername().length / 2)
                .mapToObj(i ->
                        Employee.builder().empId(i + 1l).empName(config.getUsername()[i])
                                .manager(managers.get(random.nextInt(0, managers.size()))).build()).toList();

        empService.saveEmployees(employees);
        return employees;
    }

}
