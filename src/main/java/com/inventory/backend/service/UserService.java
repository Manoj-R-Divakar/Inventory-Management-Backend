package com.inventory.backend.service;
import com.inventory.backend.dto.UserRequest;
import com.inventory.backend.entity.User;
import com.inventory.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public String registerUser(UserRequest request) {

        // Check duplicate email
        if (repo.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        // Convert DTO → Entity
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // (we'll encrypt later)

        repo.save(user);

        return "User registered successfully";
    }
}