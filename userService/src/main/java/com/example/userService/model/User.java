package com.example.userService.model;

import jakarta.persistence.*;

@Entity
public class  User {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @Enumerated(EnumType.STRING)
    UserType type;

    //Used by the JPA
    protected User(){
    }

    //Used by the application
    public User(String name,UserType type){
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public UserType getType(){
        return type;
    }
}
