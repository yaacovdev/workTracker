package com.worktracker.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worktracker.api.service.UserService;

import jakarta.validation.Valid;

import com.worktracker.api.model.User;
import com.worktracker.api.model.LoginRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        return userService.login(email, password);
    }

}