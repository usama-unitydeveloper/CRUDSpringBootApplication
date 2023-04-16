package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API Layer -> Contains get,set,post and delete
@RestController
@RequestMapping("/api/v1/student")
public class StudentController
{
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }
    @PostMapping(consumes = "application/json")
    public Student addNewStudent(@RequestBody Student student)
    {
       return studentService.addNewStudent(student);
    }
    @DeleteMapping(consumes = "application/json")
    public void removeOldStudent(@RequestBody Student student)
    {
        studentService.removeOldStudent(student);
    }
    @PutMapping(consumes = "application/json")
    public void updateNewStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }
}
