package com.example.Secure_Note_Taking_Application.service;

import com.example.Secure_Note_Taking_Application.dto.RegisterRequest;
import com.example.Secure_Note_Taking_Application.dto.RegistrationResponse;
import com.example.Secure_Note_Taking_Application.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AppUserRepo appUserRepo;
    private final AuthenticationManager authenticationManager;

    public  ResponseEntity<RegistrationResponse> login(RegisterRequest registerRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(registerRequest.getName(), registerRequest.getPassword())
            );
        }catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body(
                    new RegistrationResponse(registerRequest.getName(), "Invalid name")
            );
        }

        String token = Base64.getEncoder()
                .encodeToString((registerRequest.getName() + ":" + registerRequest.getPassword()).getBytes());

        return ResponseEntity.ok(new RegistrationResponse(
                registerRequest.getRoles()+" "+registerRequest.getName()+" login successfully",
                "Your token is: " + token
        ));
    }
}
