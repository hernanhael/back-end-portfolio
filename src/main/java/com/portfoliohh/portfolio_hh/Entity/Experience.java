package com.portfoliohh.portfolio_hh.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String experienceName; 
    private String experienceDescription; 
    
    //Constructors

    public Experience() {
    }

    public Experience(String experienceName, String experienceDescription) {
        this.experienceName = experienceName;
        this.experienceDescription = experienceDescription;
    }
    
    //Getters and Setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExperienceName() {
        return experienceName;
    }

    public void setExperienceName(String experienceName) {
        this.experienceName = experienceName;
    }

    public String getExperienceDescription() {
        return experienceDescription;
    }

    public void setExperienceDescription(String experienceDescription) {
        this.experienceDescription = experienceDescription;
    }
    
}
