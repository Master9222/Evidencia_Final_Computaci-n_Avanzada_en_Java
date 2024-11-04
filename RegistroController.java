package com.imc.imc_app.web.controller;

import com.imc.imc_app.domain.dto.UsuarioDTO;
import com.imc.imc_app.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro") // Define la ruta base para este controlador
public class RegistroController {

    private final UsuarioService usuarioService;

    @Autowired
    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping // Maneja las solicitudes POST para el registro
    public ResponseEntity<String> handleRegistro(@RequestBody UsuarioDTO usuarioDTO) {
        // Validar los datos del registro
        if (!validarRegistro(usuarioDTO)) {
            return ResponseEntity.badRequest().body("Datos de registro inválidos");
        }

        // Guardar el usuario en la base de datos
        try {
            usuarioService.createUser(usuarioDTO);
            return ResponseEntity.ok("Registro exitoso. Redirigiendo a login.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private boolean validarRegistro(UsuarioDTO usuarioDTO) {
        // Implementa aquí la lógica para validar los datos del registro
        if (usuarioDTO.getNombreCompleto() == null || usuarioDTO.getNombreCompleto().isEmpty() ||
                usuarioDTO.getEdad() == null || usuarioDTO.getEdad() < 15 ||
                usuarioDTO.getSexo() == null || (!usuarioDTO.getSexo().equalsIgnoreCase("masculino") && !usuarioDTO.getSexo().equalsIgnoreCase("femenino")) ||
                usuarioDTO.getEstatura() == null || usuarioDTO.getEstatura() <= 0 ||
                usuarioDTO.getUsername() == null || usuarioDTO.getUsername().isEmpty() ||
                usuarioDTO.getPassword() == null || usuarioDTO.getPassword().isEmpty()) {
            return false; // Datos no válidos
        }
        return true; // Devuelve true si los datos son válidos
    }
}

