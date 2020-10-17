package com.example.kerem.service;

import com.example.kerem.entity.User;
import com.example.kerem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User updatedUser, Long id){
        User user = new User();
        user.setUserName(updatedUser.getUserName());
        user.setUserSurname(updatedUser.getUserSurname());
        user.setUserEmail(updatedUser.getUserEmail());
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
