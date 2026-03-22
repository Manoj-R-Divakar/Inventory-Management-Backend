package com.inventory.backend.controller;

import com.inventory.backend.dto.UserRequest;
import com.inventory.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public String signup(@RequestBody UserRequest request) {
        return service.registerUser(request);
    }
}