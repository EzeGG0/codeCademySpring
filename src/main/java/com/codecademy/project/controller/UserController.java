package com.codecademy.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codecademy.project.entity.User;
import com.codecademy.project.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        List<User> allUser = userRepository.findAll();
        return allUser;
    }
    

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        Optional<User> existingUserOptional = userRepository.findByName(newUser.getName());

        if(existingUserOptional.isPresent()) {
            return null;
        }
        User savedUser = userRepository.save(newUser);
        return ResponseEntity.ok(savedUser);
    }
}
