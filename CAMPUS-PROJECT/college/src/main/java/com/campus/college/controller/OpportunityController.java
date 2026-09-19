// package com.campus.college.controller;

// import com.campus.college.entity.Opportunity;
// import com.campus.college.service.OpportunityService;
// import com.campus.college.dto.OpportunityDTO;

// import java.util.List;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/opportunities")
// public class OpportunityController {

//     public OpportunityService service;

//     public OpportunityController(OpportunityService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public Opportunity createOpportunity(
//             @Valid @RequestBody OpportunityDTO opportunityDTO) {

//         return service.createOpportunity(opportunityDTO);
//     }

//     // Pagination + Sorting
//     @GetMapping
//     public Page<Opportunity> getAllOpportunities(Pageable pageable) {

//         return service.getOpportunities(pageable);
//     }

//     // Get opportunity by ID
//     @GetMapping("/{id}")
//     public Opportunity getbyid(@PathVariable Long id) {

//         return service.getbyid(id);
//     }

//     // Update opportunity
//     @PutMapping("/{id}")
//     public Opportunity update(
//             @PathVariable Long id,
//             @Valid @RequestBody OpportunityDTO opportunityDTO) {

//         return service.update(id, opportunityDTO);
//     }

//     // Delete opportunity
//     @DeleteMapping("/{id}")
//     public void delete(@PathVariable Long id) {

//         service.delete(id);
//     }

//     // Search using derived query
//     @GetMapping("/search")
//     public List<Opportunity> searchByCompany(
//             @RequestParam String company) {

//         return service.searchByCompany(company);
//     }

//     // Search using @Query
//     @GetMapping("/search-query")
//     public List<Opportunity> searchByCompanyUsingQuery(
//             @RequestParam String company) {

//         return service.findByCompanyUsingQuery(company);
//     }
// }

package com.campus.college.controller;

import com.campus.college.entity.Opportunity;
import com.campus.college.service.OpportunityService;
import com.campus.college.dto.OpportunityDTO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/opportunities")
public class OpportunityController {

    public OpportunityService service;

    public OpportunityController(OpportunityService service) {
        this.service = service;
    }

    @PostMapping
    public Opportunity createOpportunity(
            @Valid @RequestBody OpportunityDTO opportunityDTO) {

        return service.createOpportunity(opportunityDTO);
    }

    // Pagination + Sorting
    @GetMapping
    public Page<Opportunity> getAllOpportunities(Pageable pageable) {

        return service.getOpportunities(pageable);
    }

    // Get opportunity by ID
    @GetMapping("/{id}")
    public Opportunity getbyid(@PathVariable Long id) {

        return service.getbyid(id);
    }

    // Get opportunities by type
    @GetMapping("/type/{type}")
    public List<Opportunity> getByType(@PathVariable String type) {

        return service.getByType(type);
    }

    // Update opportunity
    @PutMapping("/{id}")
    public Opportunity update(
            @PathVariable Long id,
            @Valid @RequestBody OpportunityDTO opportunityDTO) {

        return service.update(id, opportunityDTO);
    }

    // Delete opportunity
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }

    // Search using derived query
    @GetMapping("/search")
    public List<Opportunity> searchByCompany(
            @RequestParam String company) {

        return service.searchByCompany(company);
    }

    // Search using @Query
    @GetMapping("/search-query")
    public List<Opportunity> searchByCompanyUsingQuery(
            @RequestParam String company) {

        return service.findByCompanyUsingQuery(company);
    }
}