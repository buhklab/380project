package com.mycompany.project380.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;

    private String query;

    @Column(name = "courseID")
    private String courseID;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> ans = new ArrayList<>();

    public Question(long id, String query, String courseID) {
        this.questionId = id;
        this.query = query;
        this.courseID = courseID;
    }

    public List<Answer> getAnswer() {
        return this.ans;
    }

    public void setAnswer(List<Answer> answers) {
        this.ans = answers;
    }

    public void addAnswer(Answer answer) {
        ans.add(answer);
    }

    public Question() {
    }

    public long getId() {
        return questionId;
    }

    public void setId(long id) {
        this.questionId = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public List<Answer> getAns() {
        return ans;
    }

    public void setAns(List<Answer> ans) {
        this.ans = ans;
    }

}
