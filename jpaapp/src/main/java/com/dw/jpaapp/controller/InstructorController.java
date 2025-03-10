package com.dw.jpaapp.controller;

import com.dw.jpaapp.dto.InstructorDTO;
import com.dw.jpaapp.dto.InstructorGithubDTO;
import com.dw.jpaapp.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @GetMapping("/instructors")
    public ResponseEntity<List<InstructorDTO>> getAllInstructors() {
        return new ResponseEntity<>(
                instructorService.getAllInstructors(),
                HttpStatus.OK
        );
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<String> getInstructor(@PathVariable Long id) {
        return new ResponseEntity<>(
                instructorService.getInstructor(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/instructor/save")
    public ResponseEntity<InstructorDTO> saveInstructor(
            @RequestBody InstructorDTO instructorDTO) {
        return new ResponseEntity<>(
                instructorService.saveInstructor(instructorDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/instructor/github")
    public ResponseEntity<List<Object[]>> getInstructorGithub() {
        return new ResponseEntity<>(
                instructorService.getInstructorGithub(),
                HttpStatus.OK);
    }

    @GetMapping("/instructor/github/dto")
    public ResponseEntity<List<InstructorGithubDTO>> getInstructorGithub2() {
        return new ResponseEntity<>(
                instructorService.getInstructorGithub2(),
                HttpStatus.OK);
    }
}
