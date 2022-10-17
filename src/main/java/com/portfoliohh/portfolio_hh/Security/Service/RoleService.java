package com.portfoliohh.portfolio_hh.Security.Service;

import com.portfoliohh.portfolio_hh.Security.Entity.Role;
import com.portfoliohh.portfolio_hh.Security.Enums.RoleName;
import com.portfoliohh.portfolio_hh.Security.Repository.InterfaceRoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    @Autowired
    InterfaceRoleRepository IRoleRepository;

    public Optional<Role> getByRoleName(RoleName roleName) {
        return IRoleRepository.findByRoleName(roleName);
    }
    
    public void save(Role role) { 
        IRoleRepository.save(role);
    }
}
