package pro.sky.employeewebapp.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeewebapp.exception.EmployeeAlreadyAddedException;
import pro.sky.employeewebapp.exception.EmployeeNotFoundException;
import pro.sky.employeewebapp.exception.EmployeeStoragelsFullException;
import pro.sky.employeewebapp.model.Employee;
import pro.sky.employeewebapp.service.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int EMPLOYEE_STORAGE_SIZE=10;
    private List<Employee> employees= new ArrayList<>();
    private Employee employee;

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size()==EMPLOYEE_STORAGE_SIZE){
            throw new EmployeeStoragelsFullException();
        }

        Employee employee=new Employee(firstName, lastName);

        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee= new Employee(firstName, lastName);

        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }

        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees;
    }
}
