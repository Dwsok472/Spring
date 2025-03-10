package com.dw.firstprojectapp.repository;

import com.dw.firstprojectapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
