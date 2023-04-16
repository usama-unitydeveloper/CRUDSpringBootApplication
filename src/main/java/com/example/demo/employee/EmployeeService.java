package com.example.demo.employee;

import com.example.demo.student.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getEmployees()
    {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        if (!employeeRepository.findByName(employee.getName()).isPresent())
        {
            employeeRepository.save(employee);
        }
        else {
            throw new IllegalArgumentException("Employee Already Exists with same name");
        }


    }

    public void removeEmployee(Employee employee) {
        if (!employeeRepository.findByName(employee.getName()).isPresent())
        {

            employeeRepository.delete(employee);
        }
        else {
            throw new IllegalArgumentException("Employee Already Exists with same name");
        }

    }
    @Transactional
    public void updateEmployee(Employee employee) {
        if (employeeRepository.findByName(employee.getName()).isPresent()) {

            Employee employee1 = employeeRepository.findByName(employee.getName()).get();
            if (employee.getExperienceInYears() != null
                    && employee.getExperienceInYears() > 0
                    && !Objects.equals(employee1.getExperienceInYears(), employee.getExperienceInYears()))
            {
                employee1.setExperienceInYears(employee.getExperienceInYears());

            }
            if (employee.getSubjectTheyTeach() != null
                    && employee.getSubjectTheyTeach().length() > 0
                    && !Objects.equals(employee1.getSubjectTheyTeach(), employee.getSubjectTheyTeach()))
            {
                employee1.setSubjectTheyTeach(employee.getSubjectTheyTeach());

            }


        }
        else {
            throw new IllegalArgumentException("Employee Name not found");
        }

    }
}
