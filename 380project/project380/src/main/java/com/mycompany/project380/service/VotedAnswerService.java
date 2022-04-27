/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.VotedAnswerRepository;
import com.mycompany.project380.model.VotedAnswer;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author a1742
 */

@Service
public class VotedAnswerService {
    
    @Resource
    private VotedAnswerRepository votedRepo;
    
    @Transactional
    public List<VotedAnswer> getVotedAnswerByAnswerID(long vID){
        return votedRepo.findByAnswerID(String.valueOf(vID));
    }

    @Transactional
    public List<VotedAnswer> getVotedAnswers(){
        return votedRepo.findAll();
    }
    
    @Transactional
    public VotedAnswer getVotedAnswer(long id) {
        return votedRepo.findById(id).orElse(null);
    }
}
