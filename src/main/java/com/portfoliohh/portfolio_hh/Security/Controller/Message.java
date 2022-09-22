package com.portfoliohh.portfolio_hh.Security.Controller;

public class Message {
   private String message;
    
    //Constructor
    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }
    
    //Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    } 
}
