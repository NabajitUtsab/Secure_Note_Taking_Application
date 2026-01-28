package com.example.Secure_Note_Taking_Application.exceptionHandler;

import com.example.Secure_Note_Taking_Application.dto.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<CommonResponse> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.ok(
                CommonResponse.builder().
                        timestamp("timestamp :"+ Instant.now().toString()).
                        error("error :"+ e.getClass().toString()).
                        message("message :"+ e.getMessage()).
                        build()
        );
    }
}
