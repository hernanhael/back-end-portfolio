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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://fontendhh.web.app", "http://localhost:4200"})
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
    public ResponseEntity<HYS> getById(@PathVariable("id") int id) {
        if(!hysService.existsById(id)) {
            return new ResponseEntity(new Message("Unfind id"), HttpStatus.NOT_FOUND);
        }    
        HYS hys = hysService.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOHYS DTOhys) { 
        if(StringUtils.isBlank(DTOhys.getName())) 
            return new ResponseEntity(new Message("Name required"), HttpStatus.BAD_REQUEST); 
        if(hysService.existsByName(DTOhys.getName()))
            return new ResponseEntity(new Message("Skill already exists"), HttpStatus.BAD_REQUEST); 
        
        HYS hys = new HYS(DTOhys.getName(), DTOhys.getPercentage()); 
        hysService.save(hys);
        
        return new ResponseEntity(new Message("Added skill"), HttpStatus.OK); 
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DTOHYS DTOhys) {
        if(!hysService.existsById(id)) {
            return new ResponseEntity(new Message("Unfind id"), HttpStatus.BAD_REQUEST); 
        }
        if(hysService.existsByName(DTOhys.getName()) && hysService.getByName(DTOhys.getName()).get().getId() != id) {
            return new ResponseEntity(new Message("Skill already exists"), HttpStatus.BAD_REQUEST); 
        }
        if(StringUtils.isBlank(DTOhys.getName())) {
            return new ResponseEntity(new Message("Obligatory name"), HttpStatus.BAD_REQUEST); 
        }
        
        HYS hys = hysService.getOne(id).get(); 
        hys.setName(DTOhys.getName()); 
        hys.setPercentage(DTOhys.getPercentage());
        
        hysService.save(hys);
        return new ResponseEntity(new Message("Skill updated"), HttpStatus.OK);
    } 
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) { 
        if(!hysService.existsById(id))
            return new ResponseEntity(new Message("Unfind id"), HttpStatus.BAD_REQUEST); 
        
        hysService.delete(id);
        return new ResponseEntity(new Message("Skill deleted"), HttpStatus.OK);
    }
}
