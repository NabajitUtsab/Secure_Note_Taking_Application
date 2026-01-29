package com.example.Secure_Note_Taking_Application.controller;

import com.example.Secure_Note_Taking_Application.dto.RegisterRequest;
import com.example.Secure_Note_Taking_Application.service.AdminService;
import com.example.Secure_Note_Taking_Application.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final AdminService adminService;
    private final RegistrationService registrationService;




}
