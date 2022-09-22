package com.portfoliohh.portfolio_hh.Repository;

import com.portfoliohh.portfolio_hh.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceExperienceRepository extends JpaRepository<Experience, Integer> {
    public Optional<Experience> findByExperienceName(String experienceName);
    public boolean existsByExperienceName(String experienceName);    
}
