package com.example.Secure_Note_Taking_Application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String name;
    private String password;
    private Set<String> roles;
}
