/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project380.dao;

import com.mycompany.project380.model.Answer;
import com.mycompany.project380.model.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query("SELECT new Answer(a.answerId, a.content, a.questionID, a.courseID) FROM Answer a WHERE a.questionID LIKE %:questionID%")
    public List<Answer> findByQuestionID(@Param("questionID") String questionID);

}
