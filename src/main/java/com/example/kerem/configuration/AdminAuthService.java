package com.example.kerem.configuration;

import com.example.kerem.entity.Admin;
import com.example.kerem.repository.AdminRepository;
import com.example.kerem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthService implements UserDetailsService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin inDB = adminRepository.findByUsername(username);
        if(inDB == null){
            throw new UsernameNotFoundException("user not found");
        }
        return inDB;
    }
}
