package com.derrick.service_school.repository;

import com.derrick.service_school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {}
