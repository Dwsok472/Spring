package com.dw.firstprojectapp.controller;

import com.dw.firstprojectapp.dto.TravelerDTO;
import com.dw.firstprojectapp.exception.UnauthorizedTravelerException;
import com.dw.firstprojectapp.model.Traveler;
import com.dw.firstprojectapp.sevice.TravelerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TravelerController {
    @Autowired
    TravelerService travelerService;

    @GetMapping("/traveler/all")
    public ResponseEntity<List<Traveler>> getAllTraveler() {
        return new ResponseEntity<>(
                travelerService.getAllTravelers(),
                HttpStatus.OK
        );
    }

    @PostMapping("/register")
    public ResponseEntity<TravelerDTO> registerTraveler(@RequestBody TravelerDTO travelerDTO) {
        return new ResponseEntity<>(
                travelerService.registerTraveler(travelerDTO),
                HttpStatus.CREATED);
    }

    @GetMapping("/traveler/{traveler_name}")
    public ResponseEntity<Traveler> getTraveler(@PathVariable String traveler_name) {
        return new ResponseEntity<>(travelerService.getTraveler(traveler_name), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody TravelerDTO travelerDTO, HttpServletRequest request) {
        String travelerName = travelerDTO.getTravelerName();
        String password = travelerDTO.getPassword();
        if (travelerService.validateUser(travelerName, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("travelerName", travelerName);
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            throw new UnauthorizedTravelerException("Authentication Failed");
        }
    }

}

