package com.inventory.backend.auth.service;
import com.inventory.backend.auth.dto.SignupRequest;
import com.inventory.backend.auth.dto.LoginRequest;
import com.inventory.backend.auth.entity.User;
import com.inventory.backend.auth.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
@Service
public class AuthService {
    @Autowired
    private AuthRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(SignupRequest request) {

        // Check duplicate email
        if (repo.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        // Convert DTO → Entity
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        repo.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequest request) {

        Optional<User> userOptional = repo.findByEmail(request.getEmail());

        // ❌ User not found
        if (userOptional.isEmpty()) {
            return "User not found";
        }

        User user = userOptional.get();

        // ❌ Wrong password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return "Invalid password";
        }

        // ✅ SUCCESS
        return "Login successful";
    }
}