/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.controller;

import com.mycompany.project380.service.AnswerService;
import com.mycompany.project380.service.QuestionService;
import com.mycompany.project380.service.VotedAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author a1742
 */
@Controller
@RequestMapping("/view")
public class VotedAnswerController {

    @Autowired
    private AnswerService ansService;
    @Autowired
    private VotedAnswerService vansService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/votedAnswerHistory")
    public String viewHistory(ModelMap model) {
        model.addAttribute("votedDB", vansService.getVotedAnswers());
        model.addAttribute("answerDB", ansService.getAnswers());
        model.addAttribute("questionDB", questionService.getQuestions());
        return "viewVotedHistory";
    }
}
