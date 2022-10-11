package com.portfoliohh.portfolio_hh.Service;

import com.portfoliohh.portfolio_hh.Entity.HYS;
import com.portfoliohh.portfolio_hh.Repository.InterfaceHYSRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class HYSService {
    @Autowired 
    InterfaceHYSRepository hysRepository; 

    public List<HYS> list() { 
        return hysRepository.findAll(); 
    }
    
    public Optional<HYS> getOne(int id) { 
        return hysRepository.findById(id);
    }
    
    public Optional<HYS> getByName(String name) { 
        return hysRepository.findByName(name); 
    }
    
    public void save(HYS skill) { 
       hysRepository.save(skill);
    }
    
    public void delete(int id) { 
        hysRepository.deleteById( id);
    }
    
    public boolean existsById(int id) { 
        return hysRepository.existsById(id);
    } 
    
    public boolean existsByName(String name) { 
        return hysRepository.existsByName(name);
    }
}
