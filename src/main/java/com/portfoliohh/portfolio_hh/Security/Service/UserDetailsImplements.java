package com.portfoliohh.portfolio_hh.Security.Service;

import com.portfoliohh.portfolio_hh.Security.Entity.MainUser;
import com.portfoliohh.portfolio_hh.Security.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplements  implements UserDetailsService {
    @Autowired 
    UserService userService; 

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getByUserName(userName).get();
        return MainUser.build(user);

    }
    
    
}
