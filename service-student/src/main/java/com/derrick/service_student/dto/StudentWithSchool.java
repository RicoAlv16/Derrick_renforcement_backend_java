package com.derrick.service_student.dto;

import com.derrick.service_student.School;
import com.derrick.service_student.entity.Student;

public class StudentWithSchool {
    private Student student;
    private School school;

    // Constructeur
    public StudentWithSchool(Student student, School school) {
        this.student = student;
        this.school = school;
    }

    // Getters et Setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
