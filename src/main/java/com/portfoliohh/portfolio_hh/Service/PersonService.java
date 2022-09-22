package com.portfoliohh.portfolio_hh.Service;

import com.portfoliohh.portfolio_hh.Entity.Person;
import com.portfoliohh.portfolio_hh.Interface.InterfacePersonService;
import com.portfoliohh.portfolio_hh.Repository.InterfacePersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements InterfacePersonService{
    @Autowired InterfacePersonRepository interfacePersonRepository;
    
    @Override
    public List<Person> getPerson() {
        List<Person> person = interfacePersonRepository.findAll();
        return person;
    }

    @Override
    public void savePerson(Person person) {
        interfacePersonRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        interfacePersonRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = interfacePersonRepository.findById(id).orElse(null);
        return person;
    }
    
}