package com.portfoliohh.portfolio_hh.Service;

import com.portfoliohh.portfolio_hh.Entity.Education;
import com.portfoliohh.portfolio_hh.Repository.InterfaceEducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class EducationService {
    @Autowired
    InterfaceEducationRepository educationRepository; 
    
    public List<Education> list() {
        return educationRepository.findAll();
    }   
    
    public Optional<Education> getOne(int id) { 
        return educationRepository.findById(id);
    } 
    
    public Optional<Education> getByEducationName(String educationName) { 
        return educationRepository.findByEducationName(educationName);  
    }
    
    public void save(Education education) { 
        educationRepository.save(education);
    } 
    
    public void delete(int id) { 
        educationRepository.deleteById(id);        
    } 
    
    public boolean existsById(int id) { 
        return educationRepository.existsById(id);
    }
    
    public boolean existsByEducationName(String educationName) { 
        return educationRepository.existsByEducationName(educationName);
    }
}
