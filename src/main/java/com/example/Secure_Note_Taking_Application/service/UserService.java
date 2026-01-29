package com.example.Secure_Note_Taking_Application.service;

import com.example.Secure_Note_Taking_Application.dto.NoteRequest;
import com.example.Secure_Note_Taking_Application.dto.NoteResponse;
import com.example.Secure_Note_Taking_Application.entity.AppUser;
import com.example.Secure_Note_Taking_Application.entity.Note;
import com.example.Secure_Note_Taking_Application.repository.AppUserRepo;
import com.example.Secure_Note_Taking_Application.repository.NoteRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
;

@Service
@RequiredArgsConstructor
public class UserService {


    private final NoteRepo noteRepo;
    private final AppUserRepo appUserRepo;

    public ResponseEntity<List<NoteResponse>> getAllNotes(String username) {

        AppUser user = appUserRepo.findByUsername(username).orElseThrow();

        List<Note> noteList = noteRepo.findByAppUser(user);

        List<NoteResponse> noteResponses = noteList.stream().
                map(note -> NoteResponse.builder().
                        id(note.getId()).
                        title(note.getTitle()).
                        content(note.getContent()).build()
                ).toList();

        return ResponseEntity.ok(noteResponses);


    }

    public NoteResponse getNote(Long id, String username) {

        AppUser user = appUserRepo.findByUsername(username).orElseThrow();

        Note note = noteRepo.findById(id).orElseThrow();

        if (note.getAppUser().getUsername().equals(user.getUsername())) {

            return NoteResponse.builder().
                    id(note.getId()).
                    title(note.getTitle()).
                    content(note.getContent()).
                    build();

        }

        return null;
    }

    public ResponseEntity<?> createNote(NoteRequest noteRequest, String username) {

        AppUser user = appUserRepo.findByUsername(username).orElseThrow();

        noteRepo.save(Note.builder().
                title(noteRequest.getTitle()).
                content(noteRequest.getContent()).
                appUser(user).
                build());

        return ResponseEntity.ok("Created successfully");
    }


    public ResponseEntity<?> updateNote(NoteRequest noteRequest, Long id, String username) {

        AppUser user = appUserRepo.findByUsername(username).orElseThrow();

        Note note = noteRepo.findById(id).orElseThrow();

        if (note.getAppUser().getUsername().equals(user.getUsername())) {
            note.setId(id);
            note.setTitle(noteRequest.getTitle());
            note.setContent(noteRequest.getContent());

            noteRepo.save(note);

            return ResponseEntity.ok("Note successfully updated");
        }

        return ResponseEntity.ok("Note does not exist");

    }



    public ResponseEntity<?> deleteNote(Long id, String username) {

        AppUser user = appUserRepo.findByUsername(username).orElseThrow();

        Note note = noteRepo.findById(id).orElseThrow();

        if (note.getAppUser().getUsername().equals(user.getUsername())) {
            noteRepo.delete(note);
            return ResponseEntity.ok("Deleted successfully");
        }

        return ResponseEntity.badRequest().build();
    }


}
