package com.example.Secure_Note_Taking_Application.service;

import com.example.Secure_Note_Taking_Application.dto.RegisterRequest;
import com.example.Secure_Note_Taking_Application.dto.RegistrationResponse;
import com.example.Secure_Note_Taking_Application.entity.AppUser;
import com.example.Secure_Note_Taking_Application.entity.Note;
import com.example.Secure_Note_Taking_Application.repository.AppUserRepo;
import com.example.Secure_Note_Taking_Application.repository.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final NoteRepo noteRepo;


    public ResponseEntity<List<Note>> getAllNotes() {

        List<Note> notes = noteRepo.findAll();

        return ResponseEntity.ok(notes);
    }

    public ResponseEntity<?> deleteNote(long id) {

        noteRepo.deleteById(id);

        return ResponseEntity.ok("Deleted successfully");
    }
}
