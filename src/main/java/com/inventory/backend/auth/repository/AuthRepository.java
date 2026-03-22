package com.inventory.backend.auth.repository;


import com.inventory.backend.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AuthRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}