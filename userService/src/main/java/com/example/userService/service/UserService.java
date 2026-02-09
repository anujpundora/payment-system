package com.example.userService.service;

import com.example.userService.exception.UserNotFoundException;
import com.example.userService.model.User;
import com.example.userService.model.UserType;
import com.example.userService.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
//CREATES A USER
    public User createUser(String name, UserType type){
        User user = new User(name,type);
        return userRepository.save(user);
    }
//Get user by ID
    public User getUserById(Long id){
       return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

}
