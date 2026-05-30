package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/status")
    public String status() {
        return "Application is running";
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, Help Desk!";
    }

    @GetMapping("/about")
    public String about() {
        return "Help Desk project by Student";
    }
}

