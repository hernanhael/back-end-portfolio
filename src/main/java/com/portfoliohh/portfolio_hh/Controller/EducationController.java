package com.portfoliohh.portfolio_hh.Controller;

import com.portfoliohh.portfolio_hh.DTO.DTOEducation;
import com.portfoliohh.portfolio_hh.Entity.Education;
import com.portfoliohh.portfolio_hh.Security.Controller.Message;
import com.portfoliohh.portfolio_hh.Service.EducationService;
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
@RequestMapping("/education")
@CrossOrigin(origins = {"https://fontendhh.web.app", "http://localhost:4200"}) 
public class EducationController {
    @Autowired
    EducationService educationService; 
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() { 
        List<Education> list = educationService.list();
        return new ResponseEntity(list, HttpStatus.OK); 
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) { 
        if(!educationService.existsById(id)) { 
            return new ResponseEntity(new Message("ID don't exists"), HttpStatus.BAD_REQUEST);
        }
        
        Education education = educationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);                             
    }
   
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) { 
        if(!educationService.existsById(id)) { 
            return new ResponseEntity(new Message("Id not exists"), HttpStatus.NOT_FOUND);
        }
        educationService.delete(id);
        return new ResponseEntity(new Message("Education deleted"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOEducation dtoEducation) { 
        if(StringUtils.isBlank(dtoEducation.getEducationName())) {
            return new ResponseEntity(new Message("Write a name"), HttpStatus.BAD_REQUEST);
        }
        if(educationService.existsByEducationName(dtoEducation.getEducationName())) { 
            return new ResponseEntity(new Message("The name all ready exists"), HttpStatus.BAD_REQUEST);
        }
        
        Education education = new Education(
                dtoEducation.getEducationName(), dtoEducation.getEducationDescription()
        );
        educationService.save(education);
        return new ResponseEntity(new Message("Education created"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DTOEducation dtoEducation) {
        if(!educationService.existsById(id)) { 
            return new ResponseEntity(new Message("The ID don't exists"), HttpStatus.NOT_FOUND); 
        }
        if(!educationService.existsByEducationName(dtoEducation.getEducationName()) && educationService.getByEducationName(dtoEducation.getEducationName()).get().getId() != id) { 
            return new ResponseEntity(new Message("The name all ready exists"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEducation.getEducationName())) { 
            return new ResponseEntity(new Message("Empty slot"), HttpStatus.BAD_REQUEST); 
        }
        
        Education education = educationService.getOne(id).get();
        
        education.setEducationName(dtoEducation.getEducationName());
        education.setEducationDescription(dtoEducation.getEducationDescription()); 
        
        educationService.save(education); 
        
        return new ResponseEntity(new Message("Education update"), HttpStatus.OK); 
    } 
            
}
