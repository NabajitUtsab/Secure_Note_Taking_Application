package com.example.Secure_Note_Taking_Application.controller;


import com.example.Secure_Note_Taking_Application.entity.Note;
import com.example.Secure_Note_Taking_Application.service.AdminService;
import com.example.Secure_Note_Taking_Application.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private final AdminService adminService;


    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        return adminService.getAllNotes();
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable long id){
        return adminService.deleteNote(id);
    }

}
