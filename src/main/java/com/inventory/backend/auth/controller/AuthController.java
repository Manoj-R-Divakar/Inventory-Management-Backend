package com.inventory.backend.auth.controller;

import com.inventory.backend.auth.dto.SignupRequest;
import com.inventory.backend.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        return service.registerUser(request);
    }
}