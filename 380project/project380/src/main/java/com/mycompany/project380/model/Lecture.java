/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.model;

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
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lectureID;

    private String title;

    private long CourseID;

    public Lecture(long lectureID, String title, long CourseID) {
        this.lectureID = lectureID;
        this.title = title;
        this.CourseID = CourseID;
    }

    public Lecture() {
    }

    public long getLectureID() {
        return lectureID;
    }

    public void setLectureID(long lectureID) {
        this.lectureID = lectureID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCourseID() {
        return CourseID;
    }

    public void setCourseID(long CourseID) {
        this.CourseID = CourseID;
    }
    
    
}
