package com.dw.firstprojectapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/forest/index.html")
    public String index() {
        return "forward:/index.html";
    }
    @GetMapping("/forest/singleProduct.html")
    public String singleProduct() {
        return "forward:/singleProduct.html";
    }

    @GetMapping("/forest/board.html")
    public String board() {
        return "forward:/board.html";
    }

    @GetMapping("/forest/login.html")
    public String login() {
        return "forward:/login.html";
    }

    @GetMapping("/forest/cart.html")
    public String cart() {
        return "forward:/cart.html";
    }

    @GetMapping("/forest/mypage.html")
    public String mypage() {
        return "forward:/mypage.html";
    }

    @GetMapping("/forest/video.html")
    public String video() {
        return "forward:/video.html";
    }

    @GetMapping("/forest/upload.html")
    public String upload() {
        return "forward:/upload.html";
    }
}

