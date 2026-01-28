package com.example.Secure_Note_Taking_Application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class NoteRequest {
    private String title;
    private String content;
}
