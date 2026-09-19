// package com.campus.college.config;

// import com.campus.college.entity.Student;
// import com.campus.college.repository.StudentRepository;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import org.springframework.http.HttpMethod;

// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http)
//             throws Exception {

//         http

//             .csrf(csrf -> csrf.disable())

//             .authorizeHttpRequests(auth -> auth

//                 // Anyone can view opportunities
//                 .requestMatchers(HttpMethod.GET, "/opportunities/**")
//                 .permitAll()

//                 // Only ADMIN can create opportunities
//                 .requestMatchers(HttpMethod.POST, "/opportunities/**")
//                 .hasRole("ADMIN")

//                 // Only ADMIN can update opportunities
//                 .requestMatchers(HttpMethod.PUT, "/opportunities/**")
//                 .hasRole("ADMIN")

//                 // Only ADMIN can delete opportunities
//                 .requestMatchers(HttpMethod.DELETE, "/opportunities/**")
//                 .hasRole("ADMIN")


//                 // STUDENT and ADMIN can view students
//                 .requestMatchers(HttpMethod.GET, "/students/**")
//                 .hasAnyRole("STUDENT", "ADMIN")

//                 // Anyone can create a new account
//                 .requestMatchers(HttpMethod.POST, "/students/**")
//                 .permitAll()

//                 // Only ADMIN can update students
//                 .requestMatchers(HttpMethod.PUT, "/students/**")
//                 .hasRole("ADMIN")

//                 // Only ADMIN can delete students
//                 .requestMatchers(HttpMethod.DELETE, "/students/**")
//                 .hasRole("ADMIN")

//                 // Everything else requires authentication
//                 .anyRequest().authenticated()
//             )

//             .httpBasic(httpBasic -> {});

//         return http.build();
//     }


//     @Bean
//     public PasswordEncoder passwordEncoder() {

//         return new BCryptPasswordEncoder();
//     }


//     @Bean
//     public CommandLineRunner createUsers(
//             StudentRepository studentRepository,
//             PasswordEncoder passwordEncoder) {

//         return args -> {

//             // =========================
//             // STUDENT USER
//             // =========================

//             Student student =
//                     studentRepository.findByEmail("student@gmail.com");

//             if (student == null) {

//                 student = new Student();

//                 student.setName("Test Student");
//                 student.setEmail("student@gmail.com");
//             }

//             student.setPassword(
//                 passwordEncoder.encode("1234")
//             );

//             student.setRole("STUDENT");

//             studentRepository.save(student);


//             // =========================
//             // ADMIN USER
//             // =========================

//             Student admin =
//                     studentRepository.findByEmail("admin@gmail.com");

//             if (admin == null) {

//                 admin = new Student();

//                 admin.setName("Admin");
//                 admin.setEmail("admin@gmail.com");
//             }

//             admin.setPassword(
//                 passwordEncoder.encode("admin123")
//             );

//             admin.setRole("ADMIN");

//             studentRepository.save(admin);
//         };
//     }
// }
package com.campus.college.config;

import com.campus.college.entity.Student;
import com.campus.college.repository.StudentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // =========================
                // FRONTEND
                // =========================

                .requestMatchers(
                    "/",
                    "/index.html",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()


                // =========================
                // OPPORTUNITIES
                // =========================

                .requestMatchers(
                    HttpMethod.GET,
                    "/opportunities/**"
                ).permitAll()

                .requestMatchers(
                    HttpMethod.POST,
                    "/opportunities/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.PUT,
                    "/opportunities/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.DELETE,
                    "/opportunities/**"
                ).hasRole("ADMIN")


                // =========================
                // STUDENTS
                // =========================

                .requestMatchers(
                    HttpMethod.GET,
                    "/students/**"
                ).hasAnyRole("STUDENT", "ADMIN")

                // CREATE ACCOUNT
                .requestMatchers(
                    HttpMethod.POST,
                    "/students/**"
                ).permitAll()

                .requestMatchers(
                    HttpMethod.PUT,
                    "/students/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.DELETE,
                    "/students/**"
                ).hasRole("ADMIN")


                // =========================
                // EVERYTHING ELSE
                // =========================

                .anyRequest().authenticated()
            )

            .httpBasic(httpBasic -> {});

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }


    @Bean
    public CommandLineRunner createUsers(
            StudentRepository studentRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            // =========================
            // TEST STUDENT
            // =========================

            Student student =
                    studentRepository.findByEmail("student@gmail.com");

            if (student == null) {

                student = new Student();

                student.setName("Test Student");
                student.setEmail("student@gmail.com");
            }

            student.setPassword(
                passwordEncoder.encode("1234")
            );

            student.setRole("STUDENT");

            studentRepository.save(student);


            // =========================
            // ADMIN
            // =========================

            Student admin =
                    studentRepository.findByEmail("admin@gmail.com");

            if (admin == null) {

                admin = new Student();

                admin.setName("Admin");
                admin.setEmail("admin@gmail.com");
            }

            admin.setPassword(
                passwordEncoder.encode("admin123")
            );

            admin.setRole("ADMIN");

            studentRepository.save(admin);
        };
    }
}