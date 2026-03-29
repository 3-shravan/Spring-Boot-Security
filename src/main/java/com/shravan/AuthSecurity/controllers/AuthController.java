package com.shravan.AuthSecurity.controllers;

import com.shravan.AuthSecurity.entity.User;
import com.shravan.AuthSecurity.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")

public class AuthController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/csrf-token")
    public ResponseEntity<CsrfToken> csrfToken(HttpServletRequest request) {
        Object token = request.getAttribute(CsrfToken.class.getName());
        if (!(token instanceof CsrfToken)) {
            token = request.getAttribute("_csrf");
        }
//        if (token instanceof CsrfToken) {
//            CsrfToken csrfToken = (CsrfToken) token;
//        }
        if (token instanceof CsrfToken csrfToken) {
            return ResponseEntity.ok(csrfToken);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println("Received user registration request: " + user);
        repository.save(user);
        return user;
    }

}
