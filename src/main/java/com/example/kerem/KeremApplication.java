package com.example.kerem;

import com.example.kerem.entity.Admin;
import com.example.kerem.service.AdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class KeremApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeremApplication.class, args);
    }

    /*
@Bean
    CommandLineRunner createInitialUsers(AdminService adminService){
    return (args) -> {
        Admin admin = new Admin("admin","admin");
        adminService.createAdmin(admin);
    };
}

     */
}
