package com.example.userService.dto;

import com.example.userService.model.UserType;

import javax.annotation.processing.Generated;

public class UserResponse {

    private final String  name;
    private final UserType type;
    private final Long generatedId;

    public UserResponse(Long generatedId,String name ,UserType type ){
        this.generatedId = generatedId;
        this.name = name;
        this.type = type;

    }
    public String getName(){
        return name;
    }
    public UserType getType(){
        return type;
    }
    public Long getGeneratedId(){
        return generatedId;
    }
}
