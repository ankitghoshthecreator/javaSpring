package com.Ankit.javaSpringgapp.entity;

// You will need these imports:
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private String tags;

    
    private LocalDateTime createdAt;

    // 7. Very Important: Hibernate requires an empty (No-Argument) constructor! Create one.
    public Note() {
    }

    
    // 8. Generate Getters and Setters for ALL fields (id, title, content, summary, tags, createdAt).
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getSummary(){
        return summary;
    }
    public void setSummary(String summary){
        this.summary = summary;
    }
    public String getTags(){
        return tags;
    }
    public void setTags(String tags){
        this.tags = tags;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    // (In your IDE, you can usually right-click -> Generate -> Getters and Setters)
}
