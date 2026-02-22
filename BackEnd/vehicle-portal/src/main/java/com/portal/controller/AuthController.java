package com.portal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portal.model.User;
import com.portal.service.AuthService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("/signup")
    public User signup(@RequestBody User u) {
        return service.signup(u);
    }

    @PostMapping("/login")
    public Optional<User> login(@RequestBody User u) {

        return service.login(
            u.getEmail(),
            u.getPassword(),
            u.getRole()
        );
    }
}
