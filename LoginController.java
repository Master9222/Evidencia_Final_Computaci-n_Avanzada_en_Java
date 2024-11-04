package com.imc.imc_app.web.controller;

import com.imc.imc_app.domain.dto.LoginDTO;
import com.imc.imc_app.domain.service.UsuarioService;
import com.imc.imc_app.domain.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        Optional<UsuarioDTO> optionalUsuarioDTO = usuarioService.findByUsername(loginDTO.getUsername());

        if (!optionalUsuarioDTO.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        UsuarioDTO usuarioDTO = optionalUsuarioDTO.get();

        if (!usuarioService.validatePassword(loginDTO.getPassword(), usuarioDTO.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        return ResponseEntity.ok("Login exitoso");
    }
}
