package com.example.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.entity.User;
import com.example.registration.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        // Optionally, you can hash the password before saving it
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

