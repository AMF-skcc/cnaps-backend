package com.sk.template.domain.student.model;


import com.sk.template.domain.course.model.Course;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    private String email;

    private String phone;

    @Transient
    private List<Course> courses = new java.util.ArrayList<>();

    // 예시 Methods
    public boolean enroll(Course course) { return true; }
    public boolean drop(Course course) { return true; }
    public double getGPA() { return 4.0; }
}
