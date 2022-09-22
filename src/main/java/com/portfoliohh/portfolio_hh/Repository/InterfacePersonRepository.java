package com.portfoliohh.portfolio_hh.Repository;

import com.portfoliohh.portfolio_hh.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfacePersonRepository extends JpaRepository<Person, Long>{
    
}
