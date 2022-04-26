package com.mycompany.project380.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseID;

    private String title;

    private String code;

    public Course() {
    }

    public Course(long CourseId, String title, String code) {
        this.courseID = CourseId;
        this.title = title;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getCourseId() {
        return courseID;
    }

    public void setCourseId(long CourseId) {
        this.courseID = CourseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", title=" + title + ", code=" + code + '}';
    }

}
