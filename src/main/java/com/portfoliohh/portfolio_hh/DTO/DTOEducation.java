package com.portfoliohh.portfolio_hh.DTO;

import javax.validation.constraints.NotBlank;


public class DTOEducation {
    @NotBlank
    private String educationName; 
    @NotBlank
    private String educationDescription;
    
    //Constructors 
    public DTOEducation() {
    }

    public DTOEducation(String educationName, String educationDescription) {
        this.educationName = educationName;
        this.educationDescription = educationDescription;
    }
    
    //Getters and Setters 
    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public String getEducationDescription() {
        return educationDescription;
    }

    public void setEducationDescription(String educationDescription) {
        this.educationDescription = educationDescription;
    }
    
}
