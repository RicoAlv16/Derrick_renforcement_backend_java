package com.derrick.service_school.service;

import com.derrick.service_school.entity.School;
import com.derrick.service_school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> getAll() {
        return schoolRepository.findAll();
    }

    public Optional<School> getById(Long id) {
        return schoolRepository.findById(id);
    }

    public School save(School school) {
        return schoolRepository.save(school);
    }

    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }
}

