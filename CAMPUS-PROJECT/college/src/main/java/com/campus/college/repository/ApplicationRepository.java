package com.campus.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.college.entity.Application;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    List<Application> findByStudentId(Long studentId);

    List<Application> findByOpportunityId(Long opportunityId);

}