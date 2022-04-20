package com.mycompany.project380.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @Column(name = "courseID")
    private String courseID;

    public Comment() {
    }

    public Comment(long id, String content, String courseID) {
        this.id = id;
        this.content = content;
        this.courseID = courseID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseIDStringint(String courseID) {
        this.courseID = courseID;
    }



}
