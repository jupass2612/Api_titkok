package com.juandev.tiktok.controller;

import com.juandev.tiktok.model.Usuario;
import com.juandev.tiktok.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }
}
