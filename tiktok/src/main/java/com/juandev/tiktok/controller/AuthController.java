package com.juandev.tiktok.controller;

import com.juandev.tiktok.dto.LoginRequest;
import com.juandev.tiktok.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService service;

    public AuthController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        service.login(request);
        return Map.of("message", "Login correcto");
    }
}
