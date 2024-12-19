package com.derrick.service_student.controller;

import com.derrick.service_student.dto.StudentWithSchool;
import com.derrick.service_student.entity.Student;
import com.derrick.service_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Optional<StudentWithSchool> getStudentWithSchool(@PathVariable String id) {
        return studentService.getStudentWithSchool(id);
    }
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAll();
    }
    @GetMapping("/test-on/{id}")
    public Optional<Student> findByIdd(@PathVariable String id)
    {
        return studentService.getByIdd(id);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.save(student);
        return ResponseEntity.ok(createdStudent); // Retourne les détails de l'école créée
    }
}
