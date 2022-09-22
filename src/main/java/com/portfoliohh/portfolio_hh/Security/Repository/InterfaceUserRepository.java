package com.portfoliohh.portfolio_hh.Security.Repository;

import com.portfoliohh.portfolio_hh.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName); 
    
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
