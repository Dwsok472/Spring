package com.dw.firstprojectapp.repository;

import com.dw.firstprojectapp.model.CourseCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseCompletionRepository extends JpaRepository<CourseCompletion , Long> {
}
