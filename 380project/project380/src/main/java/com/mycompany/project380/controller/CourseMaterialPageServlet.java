/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.project380.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TCH
 */
@WebServlet(name = "CourseMaterialPageServlet", urlPatterns = {"/CourseMaterialPage"})
public class CourseMaterialPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String LectureNo = request.getParameter("LectureNo");

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
                request.getRequestDispatcher("/WEB-INF/jsp/view/course.jsp")
                        .forward(request, response);
                break;
        }

        request.getRequestDispatcher("/WEB-INF/jsp/view/listLecture.jsp")
                .forward(request, response);
    }
}
