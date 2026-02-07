package com.example.payment_system.dto;

public class UserRequest {
    private final UserType type;
    private final String name;

    public UserRequest(String name,UserType type){
        this.name = name;
        this.type = type;
    }
    public String getName(){
        return name;
    }

    public UserType getType(){
        return type;
    }
}
