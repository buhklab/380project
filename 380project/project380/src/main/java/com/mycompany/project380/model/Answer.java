package com.mycompany.project380.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    private String content;

    @Column(name = "questionID")
    private String questionID;
    
    private String courseID;
    
//    private int voted;

    public Answer() {
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

//    public int getVoted() {
//        return voted;
//    }
//
//    public void setVoted(int voted) {
//        this.voted = voted;
//    }

    public Answer(long answerId, String content, String questionID, String courseID) {
        this.answerId = answerId;
        this.content = content;
        this.questionID = questionID;
        this.courseID = courseID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }


}
