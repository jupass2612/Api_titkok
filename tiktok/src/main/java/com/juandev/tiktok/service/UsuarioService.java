package com.juandev.tiktok.service;

import com.juandev.tiktok.dto.LoginRequest;
import com.juandev.tiktok.exception.CredencialesInvalidasException;
import com.juandev.tiktok.exception.UsuarioYaExisteException;
import com.juandev.tiktok.model.Usuario;
import com.juandev.tiktok.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public Usuario guardar(Usuario usuario) {
        if (repo.findByUsuario(usuario.getUsuario()).isPresent()) {
            throw new UsuarioYaExisteException("El usuario ya existe");
        }

        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return repo.save(usuario);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public void login(LoginRequest request) {
        Usuario usuario = repo.findByUsuario(request.getUsuario())
                .orElseThrow(() ->
                        new CredencialesInvalidasException("Usuario o contraseña incorrectos"));

        if (!encoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new CredencialesInvalidasException("Usuario o contraseña incorrectos");
        }
    }
}
