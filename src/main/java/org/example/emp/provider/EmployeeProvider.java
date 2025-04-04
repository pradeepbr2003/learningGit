package org.example.emp.provider;

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

import static org.example.common.CommonUtilEnum.USER_NAME;

@Component
public class EmployeeProvider {

    @Autowired
    private EmployeeService empService;

    @Autowired
    private ManagerService managerService;


    @Bean
    public List<Employee> employees() {
        Random random = new Random();
        List<Manager> managers = IntStream.range(USER_NAME.length() / 2, USER_NAME.length())
                .mapToObj(i ->
                        Manager.builder().managerId(96l + i).managerName(USER_NAME.skill()[i]).build()).toList();
        managerService.saveManager(managers);

        List<Employee> employees = IntStream.range(0, USER_NAME.length() / 2)
                .mapToObj(i ->
                        Employee.builder().empId(i + 1l).empName(USER_NAME.skill()[i])
                                .manager(managers.get(random.nextInt(0, managers.size()))).build()).toList();

        empService.saveEmployees(employees);
        return employees;
    }

}
