package com.portfoliohh.portfolio_hh.DTO;

import javax.validation.constraints.NotBlank;


public class DTOExperience {
    @NotBlank
    private String experienceName; 
    @NotBlank 
    private String experienceDescription; 

    //Constructors
    public DTOExperience() {
    }

    public DTOExperience(String experienceName, String experienceDescription) {
        this.experienceName = experienceName;
        this.experienceDescription = experienceDescription;
    }
    
    //Getters and Setters 

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
