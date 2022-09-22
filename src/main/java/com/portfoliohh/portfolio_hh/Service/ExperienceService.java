package com.portfoliohh.portfolio_hh.Service;

import com.portfoliohh.portfolio_hh.Entity.Experience;
import com.portfoliohh.portfolio_hh.Repository.InterfaceExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ExperienceService {
    @Autowired
    InterfaceExperienceRepository experienceRepository; 
    
    public List<Experience> list() {
        return experienceRepository.findAll();
    }   
    
    public Optional<Experience> getOne(int id) { 
        return experienceRepository.findById(id);
    } 
    
    public Optional<Experience> getByExperienceName(String experienceName) { 
        return experienceRepository.findByExperienceName(experienceName);  
    }
    
    public void save(Experience experience) { 
        experienceRepository.save(experience);
    } 
    
    public void delete(int id) { 
        experienceRepository.deleteById(id);        
    } 
    
    public boolean existsById(int id) { 
        return experienceRepository.existsById(id);
    }
    
    public boolean existsByExperienceName(String experienceName) { 
        return experienceRepository.existsByExperienceName(experienceName);
    }
}
