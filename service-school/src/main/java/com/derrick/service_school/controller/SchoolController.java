package com.derrick.service_school.controller;


import com.derrick.service_school.entity.School;
import com.derrick.service_school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        return ResponseEntity.of(schoolService.getById(id));
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.save(school);
    }
    //@PostMapping
    //public ResponseEntity<School> createSchool(@RequestBody School school) {
        //School createdSchool = schoolService.save(school);
        //return ResponseEntity.ok(createdSchool); // Retourne les détails de l'école créée
    //}

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        schoolService.delete(id);
    }
}

