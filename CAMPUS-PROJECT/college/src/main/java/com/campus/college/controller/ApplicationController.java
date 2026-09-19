package com.campus.college.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.college.entity.Application;
import com.campus.college.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;


    public ApplicationController(
            ApplicationService applicationService) {

        this.applicationService = applicationService;
    }


    // STUDENT APPLY
    @PostMapping("/apply/{studentId}/{opportunityId}")
    public Application apply(
            @PathVariable Long studentId,
            @PathVariable Long opportunityId) {

        return applicationService.apply(
                studentId,
                opportunityId
        );
    }


    // GET ALL APPLICATIONS
    @GetMapping
    public List<Application> getAllApplications() {

        return applicationService.getAllApplications();
    }


    // GET APPLICATION BY ID
    @GetMapping("/{id}")
    public Application getApplicationById(
            @PathVariable Long id) {

        return applicationService.getApplicationById(id);
    }


    // GET APPLICATIONS OF STUDENT
    @GetMapping("/student/{studentId}")
    public List<Application> getStudentApplications(
            @PathVariable Long studentId) {

        return applicationService
                .getStudentApplications(studentId);
    }


    // GET APPLICATIONS OF OPPORTUNITY
    @GetMapping("/opportunity/{opportunityId}")
    public List<Application> getOpportunityApplications(
            @PathVariable Long opportunityId) {

        return applicationService
                .getOpportunityApplications(opportunityId);
    }


    // ADMIN UPDATE STATUS
    @PutMapping("/{id}/status")
    public Application updateStatus(
            @PathVariable Long id,
            @RequestBody String status) {

        return applicationService.updateStatus(
                id,
                status
        );
    }


    // DELETE APPLICATION
    @DeleteMapping("/{id}")
    public void deleteApplication(
            @PathVariable Long id) {

        applicationService.deleteApplication(id);
    }
}