package com.example.MyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ResponseDTO {
    private long user_id;
    private String user_name;
    private String email;


}
