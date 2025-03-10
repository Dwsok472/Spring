package com.dw.firstprojectapp.sevice;

import com.dw.firstprojectapp.model.Course;
import com.dw.firstprojectapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
