package com.portfoliohh.portfolio_hh.Controller;


import com.portfoliohh.portfolio_hh.DTO.DTOHYS;
import com.portfoliohh.portfolio_hh.Entity.HYS;
import com.portfoliohh.portfolio_hh.Security.Controller.Message;
import com.portfoliohh.portfolio_hh.Service.HYSService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Local Host
@CrossOrigin(origins = "http://localhost:4200")

//Firebase 
//@CrossOrigin(origins = "https://fontendhh.web.app")
@RequestMapping("/skill")
public class HYSController {
    @Autowired
    HYSService hysService; 
     
   @GetMapping("/list")
    public ResponseEntity<List<HYS>> list() { 
        List<HYS> list = hysService.list(); 
        return new ResponseEntity(list, HttpStatus.OK);  
    } 
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HYS> getById(@PathVariable("id") int id){
        if(!hysService.existsById(id))
            return new ResponseEntity(new Message("Not exists"), HttpStatus.NOT_FOUND);
        HYS hys = hysService.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOHYS DTOhys) { 
        if(StringUtils.isBlank(DTOhys.getName())) 
            return new ResponseEntity(new Message("The name is obligatory"), HttpStatus.BAD_REQUEST); 
        if(hysService.existsByName(DTOhys.getName()))
            return new ResponseEntity(new Message("The Skill allready exists"), HttpStatus.BAD_REQUEST); 
        
        HYS hys = new HYS(DTOhys.getName(), DTOhys.getPercentage()); 
        hysService.save(hys);
        
        return new ResponseEntity(new Message("Skill added"), HttpStatus.OK); 
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DTOHYS DTOhys) {
        if(!hysService.existsById(id))
            return new ResponseEntity(new Message("The ID not exists"), HttpStatus.BAD_REQUEST); 
        
        if(hysService.existsByName(DTOhys.getName()) && hysService.getByName(DTOhys.getName()).get().getId() != id)
            return new ResponseEntity(new Message("The Skill all ready exists"), HttpStatus.BAD_REQUEST); 
        
        if(StringUtils.isBlank(DTOhys.getName())) 
            return new ResponseEntity(new Message("No Skill added"), HttpStatus.BAD_REQUEST); 
        
        HYS hys = hysService.getOne(id).get(); 
        hys.setName(DTOhys.getName()); 
        hys.setPercentage(DTOhys.getPercentage());
        
        hysService.save(hys);
        return new ResponseEntity(new Message("Update Skill"), HttpStatus.OK);
    } 
    
    public ResponseEntity<?> delete(@PathVariable("id") int id) { 
        if(!hysService.existsById(id))
            return new ResponseEntity(new Message("The ID not exists"), HttpStatus.BAD_REQUEST); 
        
        hysService.delete(id); 
        
        return new ResponseEntity(new Message("Skill deleted"), HttpStatus.OK);
    }
}
