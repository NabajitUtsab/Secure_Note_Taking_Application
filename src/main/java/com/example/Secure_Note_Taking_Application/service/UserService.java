package com.example.Secure_Note_Taking_Application.service;

import com.example.Secure_Note_Taking_Application.dto.NoteRequest;
import com.example.Secure_Note_Taking_Application.dto.RegisterRequest;
import com.example.Secure_Note_Taking_Application.dto.RegistrationResponse;
import com.example.Secure_Note_Taking_Application.entity.AppUser;
import com.example.Secure_Note_Taking_Application.entity.Note;
import com.example.Secure_Note_Taking_Application.repository.AppUserRepo;
import com.example.Secure_Note_Taking_Application.repository.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {


    private final NoteRepo noteRepo;
    private final AppUserRepo appUserRepo;

    public List<Note> getAllNotes(String username) {

        Optional<AppUser> user = appUserRepo.findByUsername(username);

        return noteRepo.findByAppUser(user.orElseThrow());


    }

    public Note getNote(Long id,String username) {

        Optional<AppUser>user = appUserRepo.findByUsername(username);

        Optional<Note> note = noteRepo.findById(id);

        if(note.isPresent() && note.get().getAppUser().getUsername().equals(user.get().getUsername()) ) {

            return note.orElseThrow();
        }

        return null;
    }

    public String createNote(NoteRequest noteRequest,String username) {

        AppUser user = appUserRepo.findByUsername(username).orElseThrow();

        noteRepo.save(Note.builder().
                title(noteRequest.getTitle()).
                content(noteRequest.getContent()).
                appUser(user).
                build());

        return "Created successfully";
    }


    public String updateNote(NoteRequest noteRequest,Long id,String username){

        Note note = getNote(id,username);

        note.setId(id);
        note.setTitle(noteRequest.getTitle());
        note.setContent(noteRequest.getContent());

         noteRepo.save(note);

         return "Note successfully updated";
    }


}
