package com.Ankit.javaSpringgapp.service;

import com.Ankit.javaSpringgapp.entity.Note;
import com.Ankit.javaSpringgapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    // 2. We need to use the NoteRepository. 
    // Declare a private final NoteRepository variable, and create a constructor that takes NoteRepository as an argument so Spring can "inject" it.
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // 3. Create a method that returns a List of all Notes.
    // Use noteRepository.findAll()
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // 4. Create a method that saves a new Note.
    // Set the createdAt time before saving!
    public Note createNote(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        // Return noteRepository.save(note)
        return noteRepository.save(note);
    }
}
