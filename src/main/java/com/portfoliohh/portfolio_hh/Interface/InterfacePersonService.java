package com.portfoliohh.portfolio_hh.Interface;

import com.portfoliohh.portfolio_hh.Entity.Person;
import java.util.List;

public interface InterfacePersonService {
    
    public List<Person> getPerson();
    
    public void savePerson(Person person);
    
    public void deletePerson(Long id); 
    
    public Person findPerson(Long id);

} 


