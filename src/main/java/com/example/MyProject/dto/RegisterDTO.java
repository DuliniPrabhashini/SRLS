package com.example.MyProject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {

    @NotBlank(message = "Name is required !")
    private String user_name;

    @NotBlank(message = "Password is require !")
    @Size(min = 5, max = 10, message = "Password must be between 5 - 10 characters !")
    private String password;

    @NotBlank(message = "Email is required !")
    @Email(message = "Invalid email format !")
    private String email;

}
