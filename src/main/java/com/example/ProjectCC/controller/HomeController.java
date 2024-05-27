package com.example.ProjectCC.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "home"})
    public String mainPage(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session==null||session.getAttribute("login_user")==null)
            return "redirect:/login";
        return "home";
    }
    
    @GetMapping("home2")
    public String home2(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
        return "home2";
    }
}
