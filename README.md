# AI-Powered "Second Brain" (Smart Note Taker)

This is a Spring Boot application designed to be a personal knowledge base. It allows users to create notes, which will be automatically summarized and tagged using AI. The ultimate goal is to store these notes in a Vector Database to enable semantic search and "Chatting with your notes" using Retrieval-Augmented Generation (RAG).

## Tech Stack
*   **Java 17** & **Spring Boot 3.3.5**
*   **Database:** PostgreSQL
*   **ORM:** Hibernate / Spring Data JPA
*   **AI Integration:** Spring AI (OpenAI)
*   **Build Tool:** Maven

## Current Progress

*   ✅ **Phase 1: Project Setup & Dependencies** - Configured Maven, PostgreSQL, and Spring AI.
*   ✅ **Phase 2: Domain & Database Modeling** - Created `Note` entity and `NoteRepository`.
*   ✅ **Phase 3: Core API (CRUD Operations)** - Built `NoteService` and `NoteController` for saving and retrieving notes via REST API.
*   ⏳ **Phase 4: AI Integration (Summarization & Tagging)** - *Coming soon*
*   ⏳ **Phase 5: Vector Database & RAG (Chatting with Notes)** - *Coming soon*

## Getting Started

### Prerequisites
*   Java 17 or higher
*   PostgreSQL running locally
*   An OpenAI API Key

### Configuration
1.  Open **pgAdmin** and create a new database named `secondbrain`.
2.  Set the following environment variable on your system with your real API key before running the application:
    `OPENAI_API_KEY=sk-your-openai-api-key`

### Running the Application

To run the application locally, use the Maven wrapper from the command line:

**Windows:**
```cmd
mvnw.cmd spring-boot:run
```

**macOS/Linux:**
```bash
./mvnw spring-boot:run
```

### API Endpoints

*   `GET /api/notes` - Retrieves all saved notes.
*   `POST /api/notes` - Creates a new note.
