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
    private long CourseId;

    private String title;

    private String code;

    public Course() {
    }

    public Course(long CourseId, String title, String code) {
        this.CourseId = CourseId;
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
        return CourseId;
    }

    public void setCourseId(long CourseId) {
        this.CourseId = CourseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
