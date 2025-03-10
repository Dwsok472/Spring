package com.dw.basic.controller;

import com.dw.basic.UserDTO.UserDTO;
import com.dw.basic.mode.User;
import com.dw.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/find-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(
                userService.getAllUsers(),
                HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(
            @RequestBody User user) {
        return new ResponseEntity<>(
                userService.saveUser(user),
                HttpStatus.CREATED
        );
    }
}
