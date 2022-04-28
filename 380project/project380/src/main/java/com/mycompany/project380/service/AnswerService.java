/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.AnswerRepository;
import com.mycompany.project380.model.Answer;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author a1742
 */

@Service
public class AnswerService {
    
    @Resource
    private AnswerRepository ansRepo;
    
    @Transactional
    public List<Answer> getAnswerByQID(String Qid){
        return ansRepo.findByQuestionID(Qid);
    }
    @Transactional
    public List<Answer> getAnswers(){
        return ansRepo.findAll();
    }
    
    @Transactional
    public Answer getAnswer(long id) {
        return ansRepo.findById(id).orElse(null);
    }
}
