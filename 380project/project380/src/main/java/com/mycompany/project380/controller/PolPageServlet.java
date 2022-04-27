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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author user
 */
//@WebServlet(name = "PolPageServlet", urlPatterns = {"/PolPageServlet"})
@Controller
public class PolPageServlet extends HttpServlet {

    @GetMapping("/McPoll")
    public String login(@RequestParam("MC") String MC, HttpServletRequest request) {

        switch (MC) {
            case "1":
                request.setAttribute("Question", "Q1");
                break;
            case "2":
                request.setAttribute("Question", "Q2");
                break;
            case "3":
                request.setAttribute("Question", "Q3");
                break;
            default:
                return "course";
        }

        return "pol";
    }
}
