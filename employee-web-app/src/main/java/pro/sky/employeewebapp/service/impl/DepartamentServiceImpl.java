package pro.sky.employeewebapp.service.impl;

import pro.sky.employeewebapp.exception.EmployeeNotFoundException;
import pro.sky.employeewebapp.model.Employee;
import pro.sky.employeewebapp.service.EmployeeService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class DepartamentServiceImpl implements DepartamentServise {
    private final EmployeeService employeeService;

    public DepartamentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findEmployeeWithMaxSalary(int departamentId) {
        return employeeService.findAll().stream()
                .filter(e->e.getDepartamentId()==departamentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departamentId) {
        return employeeService.findAll().stream()
                .filter(e->e.getDepartamentId()==departamentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }


    @Override
    public Collections findEmployeesByDepartament(int departamentId) {
        return employeeService.findAll().stream()
                .filter(e->e.getDepartamentId()==departamentId)
                .sorted(Comparator.comparing(Employee::getFullName));
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartament() {
        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDepartamentId));
    }
}
