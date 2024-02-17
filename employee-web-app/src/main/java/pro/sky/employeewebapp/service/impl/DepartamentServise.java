package pro.sky.employeewebapp.service.impl;

import pro.sky.employeewebapp.model.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface DepartamentServise {
    Employee findEmployeeWithMaxSalary(int departamentId);
    Employee findEmployeeWithMinSalary(int departamentId);

    Collections findEmployeesByDepartament (int departamentId);
    Map<Integer, List<Employee>>  findEmployeesByDepartament();

}
