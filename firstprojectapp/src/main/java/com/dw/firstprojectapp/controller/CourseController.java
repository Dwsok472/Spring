package com.dw.firstprojectapp.controller;

import com.dw.firstprojectapp.model.Course;
import com.dw.firstprojectapp.sevice.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(
                courseService.getAllCourses(),
                HttpStatus.OK
        );
    }
}
