package com.example.MyProject.controller;

import com.example.MyProject.dto.LoginDTO;
import com.example.MyProject.dto.RegisterDTO;
import com.example.MyProject.dto.ResponseDTO;
import com.example.MyProject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // important for the UI

public class AuthController {

    @Autowired
    private AuthService authService;

    // Register
    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterDTO registerDTO) {
        return authService.RegisterUser(registerDTO);
    }

    // Login
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDTO loginDTO) {
        return authService.LoginUser(loginDTO);
    }

    // Get user
    public ResponseDTO getUser(@RequestParam String email) {
        return authService.getUser(email);
    }

}
