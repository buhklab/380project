/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project380.dao;

import com.mycompany.project380.model.Answer;
import com.mycompany.project380.model.VotedAnswer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VotedAnswerRepository extends JpaRepository<VotedAnswer, Long> {
    
}
