package com.Ankit.javaSpringgapp.service;

import com.Ankit.javaSpringgapp.entity.Note;
import com.Ankit.javaSpringgapp.repository.NoteRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.document.Document;
import java.util.Map;


@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final ChatClient chatClient;
    private final VectorStore vectorStore;


    public NoteService(NoteRepository noteRepository, ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.noteRepository = noteRepository;
        this.chatClient = chatClientBuilder.build(); 
        this.vectorStore = vectorStore;
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

        // Save the note to the regular DB first
        Note savedNote = noteRepository.save(note);

// Save the note to the Vector DB for semantic search
        Document document = new Document(
        savedNote.getContent(), 
        Map.of("noteId", savedNote.getId(), "title", savedNote.getTitle()));
        vectorStore.add(List.of(document));

        return savedNote;

    }
}
