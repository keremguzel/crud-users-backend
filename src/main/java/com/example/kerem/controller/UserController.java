package com.example.kerem.controller;

import com.example.kerem.entity.User;
import com.example.kerem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/1.0/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        return user;
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        User user = userRepository.findById(id).get();

        user.setUserName(updatedUser.getUserName());
        user.setUserSurname(updatedUser.getUserSurname());
        user.setUserEmail(updatedUser.getUserEmail());

        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        User user = userRepository.findById(id).get();

        userRepository.deleteById(user.getUserId());

    }


}
