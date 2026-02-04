package com.juandev.tiktok.controller;

import com.juandev.tiktok.dto.JwtResponse;
import com.juandev.tiktok.dto.LoginRequest;
import com.juandev.tiktok.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        String token = service.login(
                request.getUsername(),
                request.getPassword()
        );
        return new JwtResponse(token);
    }
}
