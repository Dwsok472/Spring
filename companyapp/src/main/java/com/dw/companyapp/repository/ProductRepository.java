package com.dw.companyapp.repository;

import com.dw.companyapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product , Long> {
    @Query("SELECT p FROM Product p WHERE p.unitPrice < :price")
    List<Product> getProductsBelowPrice(double price);
    Optional<Product> findByProductName(String productName);
}
