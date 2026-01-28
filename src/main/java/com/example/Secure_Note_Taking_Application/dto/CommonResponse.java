package com.example.Secure_Note_Taking_Application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CommonResponse {

    private String timestamp;
    private String error;
    private String message;
}
