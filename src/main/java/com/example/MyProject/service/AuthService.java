package com.example.MyProject.service;

import com.example.MyProject.dto.LoginDTO;
import com.example.MyProject.dto.RegisterDTO;
import com.example.MyProject.dto.ResponseDTO;
import com.example.MyProject.entity.User;
import com.example.MyProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    // Register
    public String RegisterUser(RegisterDTO registerDTO) {
        if(userRepo.findByEmail(registerDTO.getEmail()) != null) {
            return "Email Already Exists";
        }

        User user = new User();
        user.setUser_name(registerDTO.getUser_name());
        user.setPassword(registerDTO.getPassword());
        user.setEmail(registerDTO.getEmail());

        userRepo.save(user);

        return "User Registered Successfully";
    }

    // login
    public String LoginUser(LoginDTO loginDTO) {
        User user = userRepo.findByEmail(loginDTO.getEmail());

        if (user == null) {
            return "User not found !";
        }

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            return "Wrong password !";
        }

        return "User Logged In Successfully";
    }

    // Get User
    public ResponseDTO getUser(String email) {
        User user = userRepo.findByEmail(email);

        if (user == null) {
            return null;
        }

        return new ResponseDTO(
                user.getUser_id(),
                user.getUser_name(),
                user.getEmail()
        );
    }
}
