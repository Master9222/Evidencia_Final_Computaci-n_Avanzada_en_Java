package com.imc.imc_app.web.controller;

import com.imc.imc_app.domain.dto.UsuarioDTO;
import com.imc.imc_app.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios") // Define la ruta base para la API de usuarios
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping // Obtener todos los usuarios
    public List<UsuarioDTO> getAllUsers() {
        return usuarioService.findAllUsers();
    }

    @PostMapping // Crear un nuevo usuario
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO createdUser = usuarioService.createUser(usuarioDTO);
        return ResponseEntity.status(201).body(createdUser);
    }

    @GetMapping("/{id}") // Obtener un usuario por ID
    public ResponseEntity<UsuarioDTO> getUserById(@PathVariable Integer id) {
        return usuarioService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Agrega otros métodos según sea necesario...
}
