package com.example.ProjectCC.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    
    @GetMapping("/find")
    public String find(HttpSession session, Model model) {
        if(session.getAttribute("login_user") == null) {
            return "redirect:/login";
        }
        //        model.addAttribute("login_user", session.getAttribute("login_user"));
        return "find";
    }
    
    @GetMapping("/createChat")
    public String createChat(HttpSession session, Model model) {
//        model.addAttribute("login_user", session.getAttribute("login_user"));
        return "createChat";
    }
}