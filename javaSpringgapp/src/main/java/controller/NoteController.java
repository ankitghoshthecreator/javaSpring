package com.Ankit.javaSpringgapp.controller;

import com.Ankit.javaSpringgapp.entity.Note;
import com.Ankit.javaSpringgapp.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 1. Tell Spring this class handles web requests and returns JSON by adding @RestController
@RestController
// 2. Set the base URL for this controller to "/api/notes" using @RequestMapping("/api/notes")
@RequestMapping("/api/notes")
public class NoteController {

    // 3. Inject the NoteService just like we did in the Service layer!
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // 4. Create an endpoint to get all notes. 
    // Annotate it with @GetMapping to listen for GET requests.
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    // 5. Create an endpoint to save a new note.
    // Annotate it with @PostMapping to listen for POST requests.
    // Use @RequestBody to tell Spring to take the JSON from the web request and turn it into a Note object!
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }
}
