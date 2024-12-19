package com.derrick.service_student.repository;

import com.derrick.service_student.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {}

