package com.dw.firstapp.controller;

import com.dw.firstapp.model.MileGrade;
import com.dw.firstapp.service.MileageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MileageController {
    @Autowired
    MileageService mileageService;

    @GetMapping("/find-all-mileage")
    public ResponseEntity<List<MileGrade>> getAllmileages() {
        return new ResponseEntity<>(
                mileageService.getAllmileage(),
                HttpStatus.OK
        );
    }
}
