package com.inventory.backend.auth.service;

import com.inventory.backend.auth.entity.Product;
import com.inventory.backend.auth.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();

        stats.put("totalProducts", repo.countProducts());
        stats.put("lowStock", repo.countLowStock());
        stats.put("revenue", repo.totalRevenue() != null ? repo.totalRevenue() : 0);
        stats.put("totalOrders", 0); // future feature

        return stats;
    }
}
