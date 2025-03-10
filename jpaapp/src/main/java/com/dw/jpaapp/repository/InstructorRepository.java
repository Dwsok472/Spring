package com.dw.jpaapp.repository;

import com.dw.jpaapp.model.Instructor;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    @Query("select u from Instructor u where u.id = :id")
    Optional<Instructor> findById(Long id);
}
