package com.example.kerem.controller;

import com.example.kerem.entity.User;
import com.example.kerem.entity.vm.UserVM;
import com.example.kerem.error.ApiError;
import com.example.kerem.repository.UserRepository;
import com.example.kerem.service.UserService;
import com.example.kerem.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/1.0/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Page<UserVM> getUsers(Pageable page){
        return userService.getUsers(page).map(UserVM::new);
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user){
        String userName = user.getUserName();
        String userSurname = user.getUserSurname();
        String userEmail = user.getUserEmail();
        String userGender = user.getUserGender();

        ApiError error = new ApiError(400,"valdiation error","/api/1.0/users");
        Map<String,String> validationErrors = new HashMap<>();

        if(userName == null || userName.isEmpty()){
            validationErrors.put("username","Can not be null");
            error.setValidationErrors(validationErrors);

        }
        if(userSurname == null || userSurname.isEmpty()){
            validationErrors.put("usersurname","Can not be null");
            error.setValidationErrors(validationErrors);

        }
        if(userEmail == null || userEmail.isEmpty()){
            validationErrors.put("useremail","Can not be null");
            error.setValidationErrors(validationErrors);

        }

        if(userGender == null || userGender.isEmpty() || userGender == ""){
            validationErrors.put("gender","Can not be null");
            error.setValidationErrors(validationErrors);
        }

        if(validationErrors.size() > 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        userService.createUser(user);
        return ResponseEntity.ok(new GenericResponse("user created"));
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        return user;
    }

    @PutMapping("/users/{id}")
    public GenericResponse updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        User user = userService.getUserById(id);

        user.setUserName(updatedUser.getUserName());
        user.setUserSurname(updatedUser.getUserSurname());
        user.setUserEmail(updatedUser.getUserEmail());

        userService.createUser(user);

        return new GenericResponse("user updated");
    }

    @DeleteMapping("/users/{id}")
    public GenericResponse deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new GenericResponse("user deleted");
    }


}
