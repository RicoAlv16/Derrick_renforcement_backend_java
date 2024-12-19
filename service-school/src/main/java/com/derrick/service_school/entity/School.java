package com.derrick.service_school.entity;

import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Table(name = "school")
//@AllArgsConstructor
//@NoArgsConstructor

public class School {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String address;

}
