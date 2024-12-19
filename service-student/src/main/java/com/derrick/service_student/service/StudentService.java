package com.derrick.service_student.service;

import com.derrick.service_student.School;
import com.derrick.service_student.dto.StudentWithSchool;
import com.derrick.service_student.entity.Student;
import com.derrick.service_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    // URL de l'API externe pour récupérer les détails de l'école
    private static final String SCHOOL_SERVICE_URL = "http://localhost:8081/schools/";

    public Optional<Student> getById(String id) {
        return studentRepository.findById(id);
    }
    public Student save(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    public Optional<Student> getByIdd(String id) {
        return studentRepository.findById(id);
    }

    public Optional<StudentWithSchool> getStudentWithSchool(String id) {
        Optional<Student> studentOpt = getById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            // Récupération des détails de l'école via RestTemplate
            String schoolId = student.getSchoolId();
            School school = restTemplate.getForObject(SCHOOL_SERVICE_URL + schoolId, School.class);
            return Optional.of(new StudentWithSchool(student, school));
        }
        return Optional.empty();
    }
}
