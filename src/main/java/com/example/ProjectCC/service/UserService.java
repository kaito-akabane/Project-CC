package com.example.ProjectCC.service;

import com.example.ProjectCC.dto.RegisterDto;
import com.example.ProjectCC.entity.User;
import com.example.ProjectCC.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    public void register(RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        user.setName(registerDto.getName());
        userRepository.save(user);
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
