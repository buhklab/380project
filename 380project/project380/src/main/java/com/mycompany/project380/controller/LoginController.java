/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author TCH
 */
@Controller
public class LoginController {
// for index
    @GetMapping
    public String index() {
        return "course";
    }

    @GetMapping("/applogin")
    public String login() {
        return "login";
    }
}
