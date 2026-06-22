package com.Ankit.javaSpringgapp.repository;

import com.Ankit.javaSpringgapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 1. Add the @Repository annotation to tell Spring this is a database component.
// 2. Make this interface extend JpaRepository<Note, Long> (Note is the entity, Long is the type of the ID).
@Repository
public interface NoteRepository  extends JpaRepository<Note, Long>{

}
