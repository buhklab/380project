package com.mycompany.project380.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String mimeContentType;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] content;

    @Column(name = "courseID")
    private String courseID;
    
    @Column(name = "lectureID")
    private String lectureID;

    private String type;

    public Note() {
    }

    public Note(long id, String title, String mimeContentType, byte[] content, String courseID, String lectureID, String type) {
        this.id = id;
        this.title = title;
        this.mimeContentType = mimeContentType;
        this.content = content;
        this.courseID = courseID;
        this.lectureID = lectureID;
        this.type = type;
    }

    public String getLectureID() {
        return lectureID;
    }

    public void setLectureID(String lectureID) {
        this.lectureID = lectureID;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMimeContentType() {
        return mimeContentType;
    }

    public void setMimeContentType(String mimeContentType) {
        this.mimeContentType = mimeContentType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] contents) {
        this.content = contents;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", title=" + title + ", mimeContentType=" + mimeContentType + ", content=" + content + ", courseID=" + courseID + ", lectureID=" + lectureID + ", type=" + type + '}';
    }
    
    
    
}
