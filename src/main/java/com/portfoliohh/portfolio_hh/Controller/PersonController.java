package com.portfoliohh.portfolio_hh.Controller;

import com.portfoliohh.portfolio_hh.Entity.Person;
import com.portfoliohh.portfolio_hh.Interface.InterfacePersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin(origins = {"https://fontendhh.web.app", "http://localhost:4200"})
public class PersonController {
    @Autowired InterfacePersonService interfacePersonService;
    
    @GetMapping("/person/get")
    public List<Person> getPerson(){
        return interfacePersonService.getPerson();
    }
    
    @PostMapping("/person/create")
    public String createPerson(@RequestBody Person person){
        interfacePersonService.savePerson(person);
        return "Added person";
    }
    
    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        interfacePersonService.deletePerson(id);
        return "Deleted person";
    }

    @PutMapping("/person/edit/{id}")
    public Person editPerson(@PathVariable Long id,
                               @RequestParam("name") String newName,
                               @RequestParam("lastName") String newLastName,
                               @RequestParam("image") String newImage){
        Person person = interfacePersonService.findPerson(id);
        
        person.setName(newName);
        person.setLastName(newLastName);
        person.setImage(newImage);
        
        interfacePersonService.savePerson(person);
        return person;
    }
    
   @GetMapping("/person/get/profile")
    public Person findPersona(){
        return interfacePersonService.findPerson((long)1);
    }
}