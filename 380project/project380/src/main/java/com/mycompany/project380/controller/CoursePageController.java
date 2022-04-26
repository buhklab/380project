/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.controller;

import com.mycompany.project380.model.Comment;
import com.mycompany.project380.model.Course;
import com.mycompany.project380.model.Lecture;
import com.mycompany.project380.model.Note;
import com.mycompany.project380.service.CommentService;
import com.mycompany.project380.service.CourseService;
import com.mycompany.project380.service.LectureService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author a1742
 */

@Controller
@RequestMapping("/course")
public class CoursePageController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private LectureService lecService;
    @Autowired
    private CommentService cmtService;
    
    Course currentCourse = new Course();
    
    @GetMapping({"", "/courselist"})
    public String list(ModelMap model) {
        model.addAttribute("courseDB", courseService.getCourses());
        return "courselist";
    }
    
    @GetMapping("/listLecture")
    public String listLecture(@RequestParam("courseID") String cID, ModelMap model){
        List<Course> allCourses = new ArrayList<>();
        allCourses = courseService.getCourses();
        List<Lecture> allLectures = new ArrayList<>();
        allLectures = lecService.getLectures();
        List<Lecture> lectures = new ArrayList<>();
        List<Comment> allCmts = new ArrayList<>();
        allCmts = cmtService.getComments();
        
        List<Note> lecNote = new ArrayList<>();
        List<Note> tutNote = new ArrayList<>();
 
        for(Course c : allCourses){
            if(c.getCourseId() == Long.parseLong(cID) ){
                currentCourse = c;
                break;
            }
        }
        for(Lecture l : allLectures){
            if(l.getCourseID() == Long.parseLong(cID)){
                lectures.add(l);
            }
        }
        model.addAttribute("currentCourse", currentCourse);
        model.addAttribute("lecture", lectures);
        return "listLecture";
    }
}
