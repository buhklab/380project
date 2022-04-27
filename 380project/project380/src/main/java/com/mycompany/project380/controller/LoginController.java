/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.controller;

import com.mycompany.project380.service.CourseService;
import com.mycompany.project380.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author TCH
 */
@Controller
public class LoginController {
    //for index usage
    @Autowired
    private CourseService courseService;
    @Autowired
    private LectureService lecService;
    @GetMapping
    public String index() {
        return "course";
    }
//
//    @GetMapping
//    public String index(ModelMap model) {
//        model.addAttribute("courseDB", courseService.getCourses());
//        model.addAttribute("lectureDB", lecService.getLectures());
//        return "courselist";
//    }

    @GetMapping("/applogin")
    public String login() {
        return "login";
    }
}
