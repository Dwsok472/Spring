package com.dw.firstprojectapp.repository;

import com.dw.firstprojectapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course , Long> {
}
