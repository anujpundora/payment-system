package com.example.payment_system.controller;

import com.example.payment_system.dto.UserRequest;
import com.example.payment_system.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

@PostMapping("/users")
    public ResponseEntity<UserRequest> UserRespo(@RequestBody UserRequest userRequest){
        UserResponse response = new UserResponse(
                userRequest.getName(),generatedId,userRequest.getType()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
