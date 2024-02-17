package pro.sky.employeewebapp.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeewebapp.exception.EmployeeAlreadyAddedException;
import pro.sky.employeewebapp.exception.EmployeeNotFoundException;
import pro.sky.employeewebapp.exception.EmployeeStoragelsFullException;
import pro.sky.employeewebapp.model.Employee;
import pro.sky.employeewebapp.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int EMPLOYEE_STORAGE_SIZE=10;
    private Map<String, Employee> employees= new HashMap<>();
    private Employee employee;

    @Override
    public Employee add(String firstName, String lastName, int salary, int departamentId) {
        return null;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size()==EMPLOYEE_STORAGE_SIZE){
            throw new EmployeeStoragelsFullException();
        }

        Employee employee=new Employee(firstName, lastName);

        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee= new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException();
        }

        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException();
        }

        employees.remove(employee);
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}
