package com.campus.college.service;

import com.campus.college.entity.Student;
import com.campus.college.repository.StudentRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;

    public CustomUserDetailsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Student student = studentRepository.findByEmail(email);

        if (student == null) {
            throw new UsernameNotFoundException(
                "Student not found with email: " + email
            );
        }

        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .roles(student.getRole())
                .build();
    }
}