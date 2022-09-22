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
    InterfaceEducationRepository interfaceEducationRepository;
            
    public List<Education> list() { 
        return interfaceEducationRepository.findAll();
    }
    
    public Optional<Education> getOne(int id) { 
        return interfaceEducationRepository.findById(id);
    }
    
    public Optional<Education> getByEducationName(String educationName) { 
        return interfaceEducationRepository.findByEducationName(educationName);
    } 
    
    public void save(Education education) { 
        interfaceEducationRepository.save(education); 
    }
    
    public void delete(int id) { 
        interfaceEducationRepository.deleteById(id);
    }
    
    public boolean existsById(int id) { 
        return interfaceEducationRepository.existsById(id);
    }
    
    public boolean existsByEducationName (String educationName) { 
        return interfaceEducationRepository.existsByEducationName(educationName);
    }
}
