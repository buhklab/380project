/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.project380.controller;

import com.mycompany.project380.model.Answer;
import com.mycompany.project380.model.Comment;
import com.mycompany.project380.model.Question;
import com.mycompany.project380.model.VotedAnswer;
import com.mycompany.project380.service.AnswerService;
import com.mycompany.project380.service.CommentService;
import com.mycompany.project380.service.QuestionService;
import com.mycompany.project380.service.VotedAnswerService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author user
 */
//@WebServlet(name = "PolPageServlet", urlPatterns = {"/PolPageServlet"})
@Controller
public class PolPageServlet extends HttpServlet {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService ansService;
    @Autowired
    private VotedAnswerService vansService;
    @Autowired
    private CommentService cmtService;

    @GetMapping("/McPoll")
    public String showAns(@RequestParam("MC") String qID, ModelMap model) {
        Question question = questionService.getQuestion(Long.parseLong(qID));
        List<Comment> cmts =  cmtService.getCommentByQID(qID);
        List<Answer> answers = ansService.getAnswerByQID(qID);
        // for checking current user, if need edit
        List<VotedAnswer> vans = vansService.getVotedAnswers();
        // read all voted answer no.
        List<Answerd> total = new ArrayList<>();
        for (Answer a : answers) {
            total.add(new Answerd(String.valueOf(a.getAnswerId()), String.valueOf(vansService.getVotedAnswerByAnswerID(a.getAnswerId()).size())));
        }
        
        model.addAttribute("question", question);
        model.addAttribute("cmts", cmts);
        model.addAttribute("answerDB", answers);
        model.addAttribute("total", total);
        return "pol";
    }
    // hashmap will occure error but i don know y, so use this method to pass value to jsp
    public static class Answerd {

        String answerID;
        String noOfVoted;

        public Answerd(String answerID, String noOfVoted) {
            this.answerID = answerID;
            this.noOfVoted = noOfVoted;
        }

        public String getAnswerID() {
            return answerID;
        }

        public void setAnswerID(String answerID) {
            this.answerID = answerID;
        }

        public String getNoOfVoted() {
            return noOfVoted;
        }

        public void setNoOfVoted(String noOfVoted) {
            this.noOfVoted = noOfVoted;
        }

    }
}
