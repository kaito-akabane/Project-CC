package com.example.ProjectCC.controller;

import com.example.ProjectCC.entity.User;
import com.example.ProjectCC.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("login")
    public String loginForm() {
        return "login";
    }
    
    @PostMapping("home")
    public String login(User user, HttpServletResponse response,
                        Model model, HttpServletRequest request) throws IOException {
        Optional<User> userId = repository.findById(user.getId());
        if(userId.isPresent()) {
            if(user.getPw().equals(userId.get().getPw())) {
                HttpSession session = request.getSession();
                session.setAttribute("login_user", userId);
                return "home";
            }
        }
        //로그인 실패
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('아이디 또는 비밀번호가 틀립니다.'); history.go(-1);</script>");
        out.close();
        return null;
    }
    
    @Autowired
    UserRepository repository;
}