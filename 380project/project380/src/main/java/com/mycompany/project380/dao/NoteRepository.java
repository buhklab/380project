package com.mycompany.project380.dao;

import com.mycompany.project380.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    public Note findByCourseIDAndTitle(String courseID, String title);
    
}
