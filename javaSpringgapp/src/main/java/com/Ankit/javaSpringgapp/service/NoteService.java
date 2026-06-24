package com.Ankit.javaSpringgapp.service;

import com.Ankit.javaSpringgapp.entity.Note;
import com.Ankit.javaSpringgapp.repository.NoteRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final ChatClient chatClient; 

    public NoteService(NoteRepository noteRepository, ChatClient.Builder chatClientBuilder) {
        this.noteRepository = noteRepository;
        this.chatClient = chatClientBuilder.build(); 
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
        note.setCreatedAt(LocalDateTime.now());

        // ====== NEW AI LOGIC ======
        String summaryPrompt = "Write a 1-sentence summary of this note: " + note.getContent();
        String summary = chatClient.prompt().user(summaryPrompt).call().content();
        note.setSummary(summary); 

        String tagsPrompt = "Generate exactly 3 comma-separated tags for this note: " + note.getContent();
        String tags = chatClient.prompt().user(tagsPrompt).call().content();
        note.setTags(tags); 
        // ==========================

        return noteRepository.save(note);
    }
}
