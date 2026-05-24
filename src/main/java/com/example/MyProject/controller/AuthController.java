package com.example.MyProject.controller;

import com.example.MyProject.entity.User;
import com.example.MyProject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return authService.RegisterUser(user);
    }

    // Login
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return authService.LoginUser(user.getEmail(), user.getPassword());
    }
}
