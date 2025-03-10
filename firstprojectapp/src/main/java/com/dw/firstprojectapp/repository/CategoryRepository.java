package com.dw.firstprojectapp.repository;

import com.dw.firstprojectapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
