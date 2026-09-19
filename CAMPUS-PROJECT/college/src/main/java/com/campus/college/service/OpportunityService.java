// package com.campus.college.service;

// import com.campus.college.exception.OpportunityNotFoundException;

// import java.util.List;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import com.campus.college.dto.OpportunityDTO;
// import com.campus.college.entity.Opportunity;
// import com.campus.college.repository.OpportunityRepository;

// @Service
// public class OpportunityService {

//     private final OpportunityRepository opportunityRepository;

//     public OpportunityService(OpportunityRepository opportunityRepository) {
//         this.opportunityRepository = opportunityRepository;
//     }

//     public Opportunity createOpportunity(OpportunityDTO opportunityDTO) {

//         Opportunity opportunity = new Opportunity();

//         opportunity.setTitle(opportunityDTO.getTitle());
//         opportunity.setDescription(opportunityDTO.getDescription());
//         opportunity.setCompany(opportunityDTO.getCompany());
//         opportunity.setType(opportunityDTO.getType());
//         opportunity.setDeadline(opportunityDTO.getDeadline());

//         return opportunityRepository.save(opportunity);
//     }

//     public List<Opportunity> getAllOpportunities() {
//         return opportunityRepository.findAll();
//     }

//     // Pagination
//     public Page<Opportunity> getOpportunities(Pageable pageable) {
//         return opportunityRepository.findAll(pageable);
//     }

//     // Searching
//     public List<Opportunity> searchByCompany(String company) {
//         return opportunityRepository.findByCompany(company);
//     }

//     // Searching using @Query
//     public List<Opportunity> findByCompanyUsingQuery(String company) {
//         return opportunityRepository.findOpportunitiesByCompany(company);
//     }

//     public Opportunity getbyid(Long id) {

//         Opportunity opportunity = opportunityRepository.findById(id).orElse(null);

//         if (opportunity == null) {

//             throw new OpportunityNotFoundException(
//                 "Opportunity not found with id: " + id
//             );
//         }

//         return opportunity;
//     }

//     public Opportunity update(Long id, OpportunityDTO opportunityDTO) {

//         Opportunity existing = opportunityRepository.findById(id).orElse(null);

//         if (existing != null) {

//             existing.setTitle(opportunityDTO.getTitle());
//             existing.setDescription(opportunityDTO.getDescription());
//             existing.setCompany(opportunityDTO.getCompany());
//             existing.setDeadline(opportunityDTO.getDeadline());
//             existing.setType(opportunityDTO.getType());

//             return opportunityRepository.save(existing);
//         }

//         return null;
//     }

//     public void delete(Long id) {
//         opportunityRepository.deleteById(id);
//     }
// }





package com.campus.college.service;

import com.campus.college.exception.OpportunityNotFoundException;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.campus.college.dto.OpportunityDTO;
import com.campus.college.entity.Opportunity;
import com.campus.college.repository.OpportunityRepository;

@Service
public class OpportunityService {

    private final OpportunityRepository opportunityRepository;

    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public Opportunity createOpportunity(OpportunityDTO opportunityDTO) {

        Opportunity opportunity = new Opportunity();

        opportunity.setTitle(opportunityDTO.getTitle());
        opportunity.setDescription(opportunityDTO.getDescription());
        opportunity.setCompany(opportunityDTO.getCompany());
        opportunity.setType(opportunityDTO.getType());
        opportunity.setDeadline(opportunityDTO.getDeadline());

        return opportunityRepository.save(opportunity);
    }

    public List<Opportunity> getAllOpportunities() {

        return opportunityRepository.findAll();
    }

    // Pagination
    public Page<Opportunity> getOpportunities(Pageable pageable) {

        return opportunityRepository.findAll(pageable);
    }

    // Searching
    public List<Opportunity> searchByCompany(String company) {

        return opportunityRepository.findByCompany(company);
    }

    // Searching using @Query
    public List<Opportunity> findByCompanyUsingQuery(String company) {

        return opportunityRepository.findOpportunitiesByCompany(company);
    }

    // Get opportunity by ID
    public Opportunity getbyid(Long id) {

        Opportunity opportunity = opportunityRepository.findById(id).orElse(null);

        if (opportunity == null) {

            throw new OpportunityNotFoundException(
                "Opportunity not found with id: " + id
            );
        }

        return opportunity;
    }

    // Get opportunities by type
    public List<Opportunity> getByType(String type) {

        return opportunityRepository.findByTypeIgnoreCase(type);
    }

    public Opportunity update(Long id, OpportunityDTO opportunityDTO) {

        Opportunity existing = opportunityRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setTitle(opportunityDTO.getTitle());
            existing.setDescription(opportunityDTO.getDescription());
            existing.setCompany(opportunityDTO.getCompany());
            existing.setDeadline(opportunityDTO.getDeadline());
            existing.setType(opportunityDTO.getType());

            return opportunityRepository.save(existing);
        }

        return null;
    }

    public void delete(Long id) {

        opportunityRepository.deleteById(id);
    }
}