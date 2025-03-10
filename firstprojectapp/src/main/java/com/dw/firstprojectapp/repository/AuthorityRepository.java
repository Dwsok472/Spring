package com.dw.firstprojectapp.repository;

import com.dw.firstprojectapp.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority , String> {
}
