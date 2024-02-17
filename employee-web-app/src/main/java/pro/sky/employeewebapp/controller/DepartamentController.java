package pro.sky.employeewebapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeewebapp.model.Employee;
import pro.sky.employeewebapp.service.impl.DepartamentServise;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departamets")
public class DepartamentController {

    private final DepartamentServise departamentServise;

    public DepartamentController(DepartamentServise departamentServise){
        this.departamentServise=departamentServise;
    }
    @GetMapping ("max-salary")
    public Employee findEmployeeWithMaxSalary (@RequestParam int departamentId){
        return departamentServise.findEmployeeWithMaxSalary(departamentId);
    }
    @GetMapping ("min-salary")
    public Employee findEmployeeWithMinSalary (@RequestParam int departamentId){
        return departamentServise.findEmployeeWithMinSalary(departamentId);
    }

    @GetMapping(value = "all", params = {"departamentId"})
    public Collections findEmployeeByDepartament(@RequestParam int departamentId){
        return departamentServise.findEmployeesByDepartament(departamentId);
    }
    @GetMapping("all")
    public Map<Integer, List<Employee>> findEmployeeByDepartament(){
        return departamentServise.findEmployeesByDepartament();
    }
}
