package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addNewStudent(Student student) {
        if(!studentRepository.findByEmail(student.getEmail()).isPresent())
        {
            studentRepository.save(student);
            return student;

        }
        else
        {
            throw new IllegalArgumentException("Student Already registered with same email");
        }


    }

    public  List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    public void removeOldStudent(Student student) {
        if (studentRepository.findByEmail(student.getEmail()).isPresent())
        {

            studentRepository.deleteById(studentRepository.findByEmail(student.getEmail()).get().getId());

        }
        else{
            throw new IllegalArgumentException("Student not fount");
        }
    }
    @Transactional
    public void updateStudent(Student student) {
        //find student through mail

        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {

            Student student1 = studentRepository.findByEmail(student.getEmail()).get();
            if (student.getName() != null
                    && student.getName().length() > 0
                    && !Objects.equals(student1.getName(), student.getName()))
            {
                student1.setName(student.getName());

            }
            if (student.getDob() != null
                    && !Objects.equals(student1.getDob(), student.getDob()))
            {
                student1.setDob(student.getDob());

            }
            if (
                    student.getAge() > 0
                            && !Objects.equals(student1.getAge(), student.getAge()))
            {
                student1.setAge(student.getAge());

            }

        }
        else {
            throw new IllegalArgumentException("Student email not found");
        }


    }
}
