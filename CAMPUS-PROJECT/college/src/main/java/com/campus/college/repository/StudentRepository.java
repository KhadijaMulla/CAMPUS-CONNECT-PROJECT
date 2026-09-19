package com.campus.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.college.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);
}