package com.portfoliohh.portfolio_hh.Security.DTO;

import javax.validation.constraints.NotBlank;


public class UserLogin {
    @NotBlank
    private String userName;
    @NotBlank
    private String password; 

    //Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }          
}
