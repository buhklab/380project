/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.project380.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author TCH
 */
//@WebServlet(name = "CourseMaterialPageServlet", urlPatterns = {"/CourseMaterialPage"})
@Controller
public class CourseMaterialPageServlet {

    @GetMapping("/CourseMaterialPage")
    public String login(@RequestParam("LectureNo") String LectureNo, HttpServletRequest request) {

        switch (LectureNo) {
            case "1":
                request.setAttribute("LectureName", "Lecture1(Introduction)");
                break;
            case "2":
                request.setAttribute("LectureName", "Lecture2(Servlet)");
                break;
            case "3":
                request.setAttribute("LectureName", "Lecture3(JSP)");
                break;
            default:
                return "course";
        }

        return "listLecture";
    }
}
