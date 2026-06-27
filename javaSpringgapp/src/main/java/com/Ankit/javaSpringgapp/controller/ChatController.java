package com.Ankit.javaSpringgapp.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// 1. Annotate this class as a REST Controller
// 2. Map this controller's requests to "/api/chat"
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    // 3. Construct the controller and build ChatClient injecting standard ChatClient.Builder & VectorStore
    public ChatController(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder.build();
        this.vectorStore = vectorStore;
    }

    // 4. Create a POST endpoint that accepts a query string from the user
    @PostMapping
    public String chatWithNotes(@RequestParam String message) {
        
        // 5. Search the Vector Database for the top 3 most similar notes
        List<Document> similarDocs = vectorStore.similaritySearch(
            SearchRequest.builder()
                .query(message)
                .topK(3)
                .build()
        );

        // 6. Concatenate the text contents of the found documents
        String context = similarDocs.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n\n"));

        // 7. Send the query and context to OpenAI using a System Prompt
        return chatClient.prompt()
                .system("You are an assistant for the user's second brain. Use the following note contexts to answer the question. If the information is not in the notes, say that you don't know.\n\nContext:\n" + context)
                .user(message)
                .call()
                .content();
    }
}
