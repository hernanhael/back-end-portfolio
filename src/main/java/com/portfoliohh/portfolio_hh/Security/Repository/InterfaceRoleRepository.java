package com.portfoliohh.portfolio_hh.Security.Repository;

import com.portfoliohh.portfolio_hh.Security.Entity.Role;
import com.portfoliohh.portfolio_hh.Security.Enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
