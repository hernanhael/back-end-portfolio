package com.portfoliohh.portfolio_hh.Security.Entity;

import com.portfoliohh.portfolio_hh.Security.Enums.RoleName;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Role {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName roleName; 

    
    //Constructors 
    public Role() {
    } 
    
    public Role(RoleName roleName) { 
        this.roleName = roleName;
    } 

    
    //Getters and Setters
    public int getId() { 
        return id;
    }
    
   public void setId(int id) {
        this.id = id;
    }
    
    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    
}
