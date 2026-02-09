package com.example.userService.dto;

import com.example.userService.model.UserType;

public class UserRequest {
    private String name;
    private UserType type;
    public UserRequest(){}

    public String getName(){
        return name;
    }
    public UserType getType(){
        return type;
    }
}
