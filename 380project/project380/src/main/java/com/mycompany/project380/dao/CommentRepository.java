/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project380.dao;

import com.mycompany.project380.model.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT new Comment(c.id, c.content, c.courseID, c.lectureID, c.username) FROM Comment c WHERE c.lectureID LIKE %:lectureID%")
    public List<Comment> findByLectureID(@Param("lectureID") String lectureID);
}
