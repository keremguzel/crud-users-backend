package com.example.kerem.auth;

import com.example.kerem.entity.Admin;
import com.example.kerem.repository.AdminRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    AdminRepository adminRepository;


    @PostMapping("/api/1.0/auth")
    public ResponseEntity<?> handleAuthentication(Authentication authentication){

            Admin admin = (Admin)authentication.getPrincipal();
/*
            String username = adminDetails.getUsername();
            Admin inDB = adminRepository.findByUsername(username);
*/
            return ResponseEntity.ok(admin);

    }

}
