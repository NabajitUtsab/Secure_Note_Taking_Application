package com.example.Secure_Note_Taking_Application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegistrationResponse {

    private String username;
    private String message;
}
