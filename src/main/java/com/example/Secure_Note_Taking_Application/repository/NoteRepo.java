package com.example.Secure_Note_Taking_Application.repository;

import com.example.Secure_Note_Taking_Application.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {
}
