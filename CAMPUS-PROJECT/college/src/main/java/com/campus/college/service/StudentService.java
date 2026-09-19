// package com.campus.college.service;

// import java.util.List;

// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.campus.college.entity.Student;
// import com.campus.college.exception.StudentNotFoundException;
// import com.campus.college.repository.StudentRepository;

// @Service
// public class StudentService {

//     private final StudentRepository studentRepository;
//     private final PasswordEncoder passwordEncoder;

//     public StudentService(StudentRepository studentRepository,
//                           PasswordEncoder passwordEncoder) {

//         this.studentRepository = studentRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     // CREATE STUDENT / CREATE ACCOUNT
//     public Student createStudent(Student student) {

//         student.setRole("STUDENT");

//         student.setPassword(
//             passwordEncoder.encode(student.getPassword())
//         );

//         return studentRepository.save(student);
//     }

//     // GET ALL STUDENTS
//     public List<Student> getAllStudents() {

//         return studentRepository.findAll();
//     }

//     // GET STUDENT BY ID
//     public Student getbyid(Long id) {

//         Student student = studentRepository.findById(id).orElse(null);

//         if (student == null) {

//             throw new StudentNotFoundException(
//                 "Student not found with id: " + id
//             );
//         }

//         return student;
//     }

//     // UPDATE STUDENT
//     public Student update(Long id, Student student) {

//         Student existing = studentRepository.findById(id).orElse(null);

//         if (existing != null) {

//             existing.setName(student.getName());
//             existing.setEmail(student.getEmail());
//             existing.setPhone(student.getPhone());
//             existing.setCollege(student.getCollege());
//             existing.setCourse(student.getCourse());
//             existing.setYear(student.getYear());
//             existing.setSkills(student.getSkills());
//             existing.setResumeUrl(student.getResumeUrl());

//             return studentRepository.save(existing);
//         }

//         return null;
//     }

//     // DELETE STUDENT
//     public void delete(Long id) {

//         studentRepository.deleteById(id);
//     }
// }


package com.campus.college.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campus.college.entity.Student;
import com.campus.college.exception.StudentNotFoundException;
import com.campus.college.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository,
                          PasswordEncoder passwordEncoder) {

        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // CREATE STUDENT / CREATE ACCOUNT
    public Student createStudent(Student student) {

        student.setRole("STUDENT");

        student.setPassword(
            passwordEncoder.encode(student.getPassword())
        );

        return studentRepository.save(student);
    }

    // GET ALL STUDENTS
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    // GET STUDENT BY ID
    public Student getbyid(Long id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {

            throw new StudentNotFoundException(
                "Student not found with id: " + id
            );
        }

        return student;
    }

    // GET STUDENT BY EMAIL (used by /students/me for login)
    public Student getByEmail(String email) {

        Student student = studentRepository.findByEmail(email);

        if (student == null) {

            throw new StudentNotFoundException(
                "Student not found with email: " + email
            );
        }

        return student;
    }

    // UPDATE STUDENT
    public Student update(Long id, Student student) {

        Student existing = studentRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setPhone(student.getPhone());
            existing.setCollege(student.getCollege());
            existing.setCourse(student.getCourse());
            existing.setYear(student.getYear());
            existing.setSkills(student.getSkills());
            existing.setResumeUrl(student.getResumeUrl());

            return studentRepository.save(existing);
        }

        return null;
    }

    // DELETE STUDENT
    public void delete(Long id) {

        studentRepository.deleteById(id);
    }
}