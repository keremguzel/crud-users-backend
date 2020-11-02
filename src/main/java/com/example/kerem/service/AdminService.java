package com.example.kerem.service;

import com.example.kerem.entity.Admin;
import com.example.kerem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder){
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createAdmin(Admin admin){
        admin.setPassword(this.passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }

}
