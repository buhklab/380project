package com.mycompany.project380.dao;

import com.mycompany.project380.model.Comment;
import com.mycompany.project380.model.Note;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface NoteRepository extends JpaRepository<Note, Long> {

    public Note findByCourseIDAndTitle(String courseID, String title);

    //for custom the finding method
    @Query("SELECT new Note(n.id, n.title, n.mimeContentType, n.content, n.courseID, n.lectureID, n.type) FROM Note n WHERE n.lectureID LIKE %:lectureID%")
    public List<Note> findByLectureID(@Param("lectureID") String lectureID);

    @Query("SELECT new Note(n.id, n.title, n.mimeContentType, n.content, n.courseID, n.lectureID, n.type) FROM Note n WHERE n.courseID LIKE %:courseID%")
    public List<Note> findByCourseID(@Param("courseID") String courseID);

}
