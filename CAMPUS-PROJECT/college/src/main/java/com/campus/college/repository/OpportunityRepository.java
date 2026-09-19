package com.campus.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.campus.college.entity.Opportunity;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    List<Opportunity> findByCompany(String company);

    @Query("SELECT o FROM Opportunity o WHERE o.company = :company")
    List<Opportunity> findOpportunitiesByCompany(@Param("company") String company);

    List<Opportunity> findByTypeIgnoreCase(String type);

}