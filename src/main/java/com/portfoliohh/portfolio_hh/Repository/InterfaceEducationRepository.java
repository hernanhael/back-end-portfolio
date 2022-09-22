package com.portfoliohh.portfolio_hh.Repository;

import com.portfoliohh.portfolio_hh.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceEducationRepository extends JpaRepository<Education, Integer> {
    public Optional<Education> findByEducationName(String educationName);
    public boolean existsByEducationName(String educationName); 
}
