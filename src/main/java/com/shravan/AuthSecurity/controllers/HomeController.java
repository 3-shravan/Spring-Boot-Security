package com.shravan.AuthSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String helo() {
        return "Helo to Spring boot application ";
    }

}
