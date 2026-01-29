package com.example.Secure_Note_Taking_Application.controller;

import com.example.Secure_Note_Taking_Application.dto.NoteRequest;
import com.example.Secure_Note_Taking_Application.dto.NoteResponse;
import com.example.Secure_Note_Taking_Application.entity.Note;
import com.example.Secure_Note_Taking_Application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_USER')")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getAllNotes(Authentication authentication) {
        return userService.getAllNotes(authentication.getName());
    }


    @GetMapping("/{id}")
    public NoteResponse getNoteById(@PathVariable long id,Authentication authentication) {

        return userService.getNote(id,authentication.getName());
    }


    @PostMapping
    public ResponseEntity<?> createNote(@RequestBody NoteRequest noteRequest, Authentication authentication) {

        String username = authentication.getName();

        return userService.createNote(noteRequest,username);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNote(@PathVariable long id,@RequestBody NoteRequest noteRequest,Authentication authentication){
        String username = authentication.getName();

        return userService.updateNote(noteRequest,id,username);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable long id,Authentication authentication){
        String username = authentication.getName();
        return userService.deleteNote(id,username);
    }

}
