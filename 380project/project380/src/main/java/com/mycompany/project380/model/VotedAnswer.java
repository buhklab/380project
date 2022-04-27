/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author a1742
 */
@Entity
@Table(name = "votedAnswer")
public class VotedAnswer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long votedId;

    private String answerID;
   
    private String username;

    public VotedAnswer() {
    }

    public VotedAnswer(long votedId, String answerID, String username) {
        this.votedId = votedId;
        this.answerID = answerID;
        this.username = username;
    }

    public long getVotedId() {
        return votedId;
    }

    public void setVotedId(long votedId) {
        this.votedId = votedId;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
