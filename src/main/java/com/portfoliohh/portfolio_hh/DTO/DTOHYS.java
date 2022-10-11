package com.portfoliohh.portfolio_hh.DTO;

import javax.validation.constraints.NotBlank;


public class DTOHYS {
    @NotBlank
    private String name; 
    @NotBlank
    private String percentage; 

    public DTOHYS() {
    }

    public DTOHYS(String name, String percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
    
    
}
