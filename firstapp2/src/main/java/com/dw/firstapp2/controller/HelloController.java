package com.dw.firstapp2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping ("/sayhello")
    public String Hello() {
        return "hello world";
    }
}
