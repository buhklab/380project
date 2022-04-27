/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.QuestionRepository;
import com.mycompany.project380.model.Comment;
import com.mycompany.project380.model.Question;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author a1742
 */

@Service
public class QuestionService {
    
    @Resource
    private QuestionRepository questionRepo;

    @Transactional
    public List<Question> getQuestions(){
        return questionRepo.findAll();
    }
    
    @Transactional
    public Question getQuestion(long id) {
        return questionRepo.findById(id).orElse(null);
    }
}
