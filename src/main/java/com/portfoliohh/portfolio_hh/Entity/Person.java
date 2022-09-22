package com.portfoliohh.portfolio_hh.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter 
@Entity
public class Person {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String name; 
    
    @NotNull
    private String lastName; 
    
    private String image; 
}
