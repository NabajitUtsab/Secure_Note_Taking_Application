package com.example.Secure_Note_Taking_Application.controller;

import com.example.Secure_Note_Taking_Application.dto.RegisterRequest;
import com.example.Secure_Note_Taking_Application.service.LoginService;
import com.example.Secure_Note_Taking_Application.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final LoginService loginService;



    @PostMapping("/register/admin")
    public ResponseEntity<?> createAdmin(@RequestBody RegisterRequest registerRequest){
        return registrationService.adminRegistration(registerRequest);
    }

    @PostMapping("/register/user")
    public ResponseEntity<?> createUser(@RequestBody RegisterRequest registerRequest){
        return registrationService.userRegistration(registerRequest);
    }



}
