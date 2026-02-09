package com.example.payment_system.dto;

import com.example.payment_system.model.UserType;

public class UserResponse {
    private final Long id;
    private final String name;
    private final UserType type;

    public UserResponse(String name,Long id,UserType type){
        this.id = id;
        this.name =name;
        this.type = type;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public UserType getType(){
        return type;
    }
}
