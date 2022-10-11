package com.portfoliohh.portfolio_hh.Repository;

import com.portfoliohh.portfolio_hh.Entity.HYS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InterfaceHYSRepository extends JpaRepository<HYS, Integer> {
    Optional<HYS> findByName(String name);
    
    public boolean existsByName(String name);
    
}
