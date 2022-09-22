package com.portfoliohh.portfolio_hh.Security.Service;

import com.portfoliohh.portfolio_hh.Security.Entity.User;
import com.portfoliohh.portfolio_hh.Security.Repository.InterfaceUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    InterfaceUserRepository IUserRepository; 
    
    public Optional<User> getByUserName(String userName) { 
        return IUserRepository.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName) { 
        return IUserRepository.existsByUserName(userName); 
    } 
    
    public boolean existsByEmail(String email) { 
        return IUserRepository.existsByEmail(email);
    } 
    
    public void save(User user) { 
        IUserRepository.save(user);
    }
}
