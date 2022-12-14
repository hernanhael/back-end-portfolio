package com.portfoliohh.portfolio_hh.Controller;

import com.portfoliohh.portfolio_hh.DTO.DTOExperience;
import com.portfoliohh.portfolio_hh.Entity.Experience;
import com.portfoliohh.portfolio_hh.Security.Controller.Message;
import com.portfoliohh.portfolio_hh.Service.ExperienceService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = {"https://fontendhh.web.app", "http://localhost:4200"}) 
public class ExperienceController {
    @Autowired
    ExperienceService experienceService; 
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list() { 
        List<Experience> list = experienceService.list(); 
        return new ResponseEntity(list, HttpStatus.OK);  
    } 
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Message("Id does not exist"), HttpStatus.NOT_FOUND);
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOExperience DTOExp) { 
        if(StringUtils.isBlank(DTOExp.getExperienceName())) 
            return new ResponseEntity(new Message("Name required"), HttpStatus.BAD_REQUEST); 
        if(experienceService.existsByExperienceName(DTOExp.getExperienceName()))
            return new ResponseEntity(new Message("Experience already exists"), HttpStatus.BAD_REQUEST); 
        
        Experience experience = new Experience(DTOExp.getExperienceName(), DTOExp.getExperienceDescription()); 
        experienceService.save(experience);
        
        return new ResponseEntity(new Message("Added experience"), HttpStatus.OK); 
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DTOExperience DTOExp) {
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Message("Id does not exist"), HttpStatus.NOT_FOUND); 
        
        if(experienceService.existsByExperienceName(DTOExp.getExperienceName()) && experienceService.getByExperienceName(DTOExp.getExperienceName()).get().getId() != id)
            return new ResponseEntity(new Message("Experience already exists"), HttpStatus.BAD_REQUEST); 
        
        if(StringUtils.isBlank(DTOExp.getExperienceName())) 
            return new ResponseEntity(new Message("Experience required"), HttpStatus.BAD_REQUEST); 
        
        Experience experience = experienceService.getOne(id).get(); 
        experience.setExperienceName(DTOExp.getExperienceName()); 
        experience.setExperienceDescription(DTOExp.getExperienceDescription());
        
        experienceService.save(experience);
        return new ResponseEntity(new Message("Updated experience"), HttpStatus.OK);
    } 
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) { 
        if(!experienceService.existsById(id)) {
            return new ResponseEntity(new Message("Id does not exist"), HttpStatus.NOT_FOUND); 
        }
        experienceService.delete(id);
        return new ResponseEntity(new Message("Deleted experience"), HttpStatus.OK);
    }
}
