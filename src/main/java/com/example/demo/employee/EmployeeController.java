package com.example.demo.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping()
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }

    @PostMapping(consumes = "application/json")
    public void addNewEmployee(@RequestBody Employee employee)
    {
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(consumes = "application/json")
    public void removeEmployee(Employee employee)
    {
        employeeService.removeEmployee(employee);
    }
    @PutMapping(consumes = "application/json")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }
}
