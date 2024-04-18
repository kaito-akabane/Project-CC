package com.example.ProjectCC.controller;

import com.example.ProjectCC.entity.User;
import com.example.ProjectCC.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {
    @GetMapping("join")
    public String joinForm() {
        return "join";
    }
    
    @PostMapping("join")
    public String joinUser(User user, HttpServletResponse response) throws IOException {
        Optional<User> userId = repository.findById(user.getId());
        if(userId.isEmpty()) {
            repository.save(user);
            return "login";
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script> alert('해당 ID는 이미 존재합니다.'); history.go(-1); </script>");
        out.close();
        return null;
    }
    
    @Autowired
    UserRepository repository;
}