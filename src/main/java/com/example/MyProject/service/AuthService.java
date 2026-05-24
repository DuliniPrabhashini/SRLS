package com.example.MyProject.service;

import com.example.MyProject.entity.User;
import com.example.MyProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    // Register
    public String RegisterUser(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());

        if (existingUser != null) {
            return "Email Already Exists";
        }

        userRepo.save(user);

        return "User Registered Successfully";
    }

    // login
    public String LoginUser(String email, String password) {
        User user = userRepo.findByEmail(email);

        if (user == null) {
            return "User not found !";
        }

        if (!user.getPassword().equals(password)) {
            return "Wrong password !";
        }

        return "User Logged In Successfully";
    }
}
