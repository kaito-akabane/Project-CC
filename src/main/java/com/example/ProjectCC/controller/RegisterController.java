package com.example.ProjectCC.controller;

import com.example.ProjectCC.dto.RegisterDto;
import com.example.ProjectCC.entity.User;
import com.example.ProjectCC.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegisterController {
    private final UserService userService;
    
    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("join")
    public String joinForm() {
        return "join";
    }
    
    @PostMapping("/join")
    public String join(RegisterDto registerDto, HttpServletResponse response) throws IOException {
        User username = userService.findByUsername(registerDto.getUsername());
        if(username==null) {
            userService.register(registerDto);
            return "redirect:/login";
        }
        
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script> alert('해당 ID는 이미 존재합니다.'); history.go(-1); </script>");
        out.close();
        return null;
    }
}
