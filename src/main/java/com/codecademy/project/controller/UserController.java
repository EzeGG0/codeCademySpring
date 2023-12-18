package com.codecademy.project.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.RepaintManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codecademy.project.entity.User;
import com.codecademy.project.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // GetMapping
    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        List<User> allUser = userRepository.findAll();
        return allUser;
    }
    
    @GetMapping
    public ResponseEntity<User> getUserByName(@RequestParam String name) {
        Optional<User> userOptional = userRepository.findByName(name);
        if(!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User userName = userOptional.get();
        return ResponseEntity.ok(userName);
    }

    // PostMapping
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User newUser) {
        Optional<User> existingUserOptional = userRepository.findByName(newUser.getName());

        if(existingUserOptional.isPresent()) {
            return ResponseEntity.badRequest().body("The name is in use");
        }
        User savedUser = userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

    // PutMapping
    @PutMapping("/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            return ResponseEntity.badRequest().body("The chosen user does not exist");
        }
        User updateUser = userOptional.get();

        if(updatedUser.getName() != null) {
            return ResponseEntity.badRequest().body("The name cannot be changed");
        }

        if(updatedUser.getCity() != null) {
            updateUser.setCity(updatedUser.getCity());
        }

        if(updatedUser.getState() != null) {
            updateUser.setState(updatedUser.getState());
        }

        if(updatedUser.getZipcode() != null) {
            updateUser.setZipcode(updatedUser.getZipcode());
        }

        if(updatedUser.getInterestedInDairy() != null) {
            updateUser.setInterestedInDairy(updatedUser.getInterestedInDairy());
        }
        if(updatedUser.getInterestedInEgg() != null) {
            updateUser.setInterestedInEgg(updatedUser.getInterestedInEgg());
        }
        if(updatedUser.getInterestedInPeanut() != null) {
            updateUser.setInterestedInPeanut(updatedUser.getInterestedInPeanut());
        }
        userRepository.save(updateUser);
        return ResponseEntity.ok().build();
    }

    // DeleteMapping
}
