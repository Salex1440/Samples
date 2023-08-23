package com.salex.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class GreetingController {

    @GetMapping("/stranger")
    public String greetStranger() {
        return "Hello, stranger!";
    }

    @GetMapping("/user")
    public String greetUser() {
        return "Hello, user!";
    }

    @GetMapping("/admin")
    public String greetAdmin() {
        return "Hello, admin!";
    }
}
