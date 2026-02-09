package com.example.userService.controller;

import com.example.userService.dto.UserRequest;
import com.example.userService.dto.UserResponse;
import com.example.userService.model.User;
import com.example.userService.repository.UserRepository;
import com.example.userService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody UserRequest request) {

        User user = userService.createUser(
                request.getName(),
                request.getType()
        );

        UserResponse response = new UserResponse(
                user.getId(),
                user.getName(),
                user.getType()
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

@GetMapping("/{id}")
public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        UserResponse response = new  UserResponse(
                user.getId(),
                user.getName(),
                user.getType()
        );
        return ResponseEntity.ok(response);
}
}
