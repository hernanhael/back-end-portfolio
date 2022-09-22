package com.portfoliohh.portfolio_hh.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; 
    private String educationName;
    private String educationDescription;

    //Constructors
    public Education() {
    }

    public Education(String educationName, String educationDescription) {
        this.educationName = educationName;
        this.educationDescription = educationDescription;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String eduactionName) {
        this.educationName = eduactionName;
    }

    public String getEducationDescription() {
        return educationDescription;
    }

    public void setEducationDescription(String educationDescription) {
        this.educationDescription = educationDescription;
    }
    
}
