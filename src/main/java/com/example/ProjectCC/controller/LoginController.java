package com.example.ProjectCC.controller;

import com.example.ProjectCC.dto.LoginDto;
import com.example.ProjectCC.entity.User;
import com.example.ProjectCC.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final UserRepository userRepository;
    
    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("login")
    public String login(LoginDto loginDto, HttpServletResponse response, HttpServletRequest request)
            throws IOException {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if(user!=null) {
            if(loginDto.getPassword().equals(user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("login_user", user);
                return "redirect:/home";
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

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
}