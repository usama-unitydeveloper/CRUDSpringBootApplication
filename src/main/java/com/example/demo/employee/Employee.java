package com.example.demo.employee;

import jakarta.persistence.*;

@Entity
@Table

public class Employee {
    @Id
    @SequenceGenerator(name = "employee_sequence",
    sequenceName = "employee_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "employee_sequence")
    private Long id;
    private String name;
    private Long experienceInYears;
    private String subjectTheyTeach;

    public Employee(Long id, String name, Long experienceInYears, String subjectTheyTeach) {
        this.id = id;
        this.name = name;
        this.experienceInYears = experienceInYears;
        this.subjectTheyTeach = subjectTheyTeach;
    }

    public Employee(String name, Long experienceInYears, String subjectTheyTeach) {
        this.name = name;
        this.experienceInYears = experienceInYears;
        this.subjectTheyTeach = subjectTheyTeach;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(Long experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public String getSubjectTheyTeach() {
        return subjectTheyTeach;
    }

    public void setSubjectTheyTeach(String subjectTheyTeach) {
        this.subjectTheyTeach = subjectTheyTeach;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experienceInYears=" + experienceInYears +
                ", subjectTheyTeach='" + subjectTheyTeach + '\'' +
                '}';
    }
}
