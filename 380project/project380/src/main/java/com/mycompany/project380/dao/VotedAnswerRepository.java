/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project380.dao;

import com.mycompany.project380.model.Answer;
import com.mycompany.project380.model.Comment;
import com.mycompany.project380.model.VotedAnswer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VotedAnswerRepository extends JpaRepository<VotedAnswer, Long> {
    // two votedAnswer must be the class name instead of the table name
    @Query("SELECT new VotedAnswer(v.votedId, v.answerID, v.username) FROM VotedAnswer v WHERE v.answerID LIKE %:answerID%")
    public List<VotedAnswer> findByAnswerID(@Param("answerID") String answerID);
}
