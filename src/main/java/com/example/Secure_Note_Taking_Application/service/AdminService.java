package com.example.Secure_Note_Taking_Application.service;

import com.example.Secure_Note_Taking_Application.dto.RegisterRequest;
import com.example.Secure_Note_Taking_Application.dto.RegistrationResponse;
import com.example.Secure_Note_Taking_Application.entity.AppUser;
import com.example.Secure_Note_Taking_Application.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AppUserRepo appUserRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    ResponseEntity<RegistrationResponse> AdminRegistration(RegisterRequest registerRequest){


        appUserRepo.save(AppUser.builder().
                username(registerRequest.getName()).
                password(bCryptPasswordEncoder.encode(registerRequest.getPassword())).
                roles(Set.of("ADMIN")).
                build());

        return ResponseEntity.ok(RegistrationResponse.builder().
                username("name : "+registerRequest.getName()).
                message("message : Admin Registration successful!").
                build());
    }
}
