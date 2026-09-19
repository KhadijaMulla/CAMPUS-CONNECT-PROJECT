package com.campus.college.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.campus.college.entity.Application;
import com.campus.college.entity.Opportunity;
import com.campus.college.entity.Student;
import com.campus.college.repository.ApplicationRepository;
import com.campus.college.repository.OpportunityRepository;
import com.campus.college.repository.StudentRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final OpportunityRepository opportunityRepository;


    public ApplicationService(
            ApplicationRepository applicationRepository,
            StudentRepository studentRepository,
            OpportunityRepository opportunityRepository) {

        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.opportunityRepository = opportunityRepository;
    }


    // STUDENT APPLY FOR OPPORTUNITY
    public Application apply(
            Long studentId,
            Long opportunityId) {

        Student student =
                studentRepository.findById(studentId).orElse(null);

        if (student == null) {
            throw new RuntimeException(
                    "Student not found with id: " + studentId
            );
        }


        Opportunity opportunity =
                opportunityRepository.findById(opportunityId).orElse(null);

        if (opportunity == null) {
            throw new RuntimeException(
                    "Opportunity not found with id: " + opportunityId
            );
        }


        Application application = new Application();

        application.setStudent(student);
        application.setOpportunity(opportunity);

        application.setStatus("APPLIED");

        application.setAppliedAt(LocalDateTime.now());

        return applicationRepository.save(application);
    }


    // GET ALL APPLICATIONS
    public List<Application> getAllApplications() {

        return applicationRepository.findAll();
    }


    // GET APPLICATION BY ID
    public Application getApplicationById(Long id) {

        Application application =
                applicationRepository.findById(id).orElse(null);

        if (application == null) {
            throw new RuntimeException(
                    "Application not found with id: " + id
            );
        }

        return application;
    }


    // GET APPLICATIONS OF ONE STUDENT
    public List<Application> getStudentApplications(Long studentId) {

        Student student =
                studentRepository.findById(studentId).orElse(null);

        if (student == null) {
            throw new RuntimeException(
                    "Student not found with id: " + studentId
            );
        }

        return applicationRepository.findByStudentId(studentId);
    }


    // GET APPLICATIONS FOR ONE OPPORTUNITY
    public List<Application> getOpportunityApplications(
            Long opportunityId) {

        Opportunity opportunity =
                opportunityRepository.findById(opportunityId).orElse(null);

        if (opportunity == null) {
            throw new RuntimeException(
                    "Opportunity not found with id: " + opportunityId
            );
        }

        return applicationRepository.findByOpportunityId(opportunityId);
    }


    // ADMIN CHANGE APPLICATION STATUS
    public Application updateStatus(
            Long id,
            String status) {

        Application application =
                applicationRepository.findById(id).orElse(null);

        if (application == null) {
            throw new RuntimeException(
                    "Application not found with id: " + id
            );
        }


        application.setStatus(status);

        return applicationRepository.save(application);
    }


    // DELETE APPLICATION
    public void deleteApplication(Long id) {

        Application application =
                applicationRepository.findById(id).orElse(null);

        if (application == null) {
            throw new RuntimeException(
                    "Application not found with id: " + id
            );
        }

        applicationRepository.delete(application);
    }
}