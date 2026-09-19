// package com.campus.college.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.campus.college.entity.Student;
// import com.campus.college.service.StudentService;

// @RestController
// @RequestMapping("/students")
// public class StudentController {

//     private final StudentService service;

//     public StudentController(StudentService service) {

//         this.service = service;
//     }

//     @PostMapping
//     public Student createStudent(@RequestBody Student student) {

//         return service.createStudent(student);
//     }

//     @GetMapping
//     public List<Student> getAllStudents() {

//         return service.getAllStudents();
//     }

//     @GetMapping("/{id}")
//     public Student getbyid(@PathVariable Long id) {

//         return service.getbyid(id);
//     }

//     @PutMapping("/{id}")
//     public Student update(
//             @PathVariable Long id,
//             @RequestBody Student student) {

//         return service.update(id, student);
//     }

//     @DeleteMapping("/{id}")
//     public void delete(@PathVariable Long id) {

//         service.delete(id);
//     }
// }







package com.campus.college.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.college.entity.Student;
import com.campus.college.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {

        this.service = service;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {

        return service.createStudent(student);
    }

    // CURRENT LOGGED-IN STUDENT (used by frontend to validate login)
    @GetMapping("/me")
    public Student me(@AuthenticationPrincipal UserDetails principal) {

        return service.getByEmail(principal.getUsername());
    }

    @GetMapping
    public List<Student> getAllStudents() {

        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getbyid(@PathVariable Long id) {

        return service.getbyid(id);
    }

    @PutMapping("/{id}")
    public Student update(
            @PathVariable Long id,
            @RequestBody Student student) {

        return service.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }
}