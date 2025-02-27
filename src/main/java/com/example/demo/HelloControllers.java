package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllers {
    @GetMapping("/")
    public String index() {
        return "Hello World from Spring Boot! Thanh Chau hello";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Hello World from Spring Boot! User";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Hello World from Spring Boot! Admin";
    }
}
