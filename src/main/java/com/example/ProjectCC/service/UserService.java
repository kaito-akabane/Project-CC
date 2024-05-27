package com.example.ProjectCC.service;

import com.example.ProjectCC.dto.LoginDto;
import com.example.ProjectCC.dto.RegisterDto;
import com.example.ProjectCC.entity.User;
import com.example.ProjectCC.repository.UserRepository;
import com.example.ProjectCC.security.Encrypt;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    public boolean register(RegisterDto registerDto) {
        User username = userRepository.findByUsername(registerDto.getUsername());
        if(username!=null) return false;
        else {
            User user = new User();
            user.setUsername(registerDto.getUsername());
            user.setPassword(Encrypt.encrypt(registerDto.getPassword()));
            user.setName(registerDto.getName());
            user.setEmail(registerDto.getEmail()+"@g.yju.ac.kr");
            userRepository.save(user);
            return true;
        }
    }
    
    public User login(LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if(user!=null&&user.getPassword().equals(Encrypt.encrypt(loginDto.getPassword())))
            return user;
        return null;
    }
    
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public User findById(Integer id) {
//        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
//    }
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
}
