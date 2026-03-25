package com.inventory.backend.auth.repository;

import com.inventory.backend.auth.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT COUNT(p) FROM Product p")
    long countProducts();

    @Query("SELECT COUNT(p) FROM Product p WHERE p.quantity < 10")
    long countLowStock();

    @Query("SELECT SUM(p.price * p.quantity) FROM Product p")
    Double totalRevenue();
}