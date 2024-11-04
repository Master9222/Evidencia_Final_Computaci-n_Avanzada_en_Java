package com.imc.imc_app.web.controller;

import com.imc.imc_app.domain.dto.CalculoIMCDTO; // DTO para recibir datos de IMC
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/imc") // Define la ruta base para este controlador
public class IMCController {

    @PostMapping("/calcular") // Manejando solicitudes POST para calcular el IMC
    public ResponseEntity<String> calcularIMC(@RequestBody CalculoIMCDTO calculoIMCDTO) {
        // Extraer los valores de estatura y masa corporal
        float estatura = calculoIMCDTO.getEstatura(); // Asume que los datos vienen en metros
        float masaCorporal = calculoIMCDTO.getMasaCorporal(); // Asume que los datos vienen en kilogramos

        // Validación de los valores
        if (estatura <= 0 || masaCorporal <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La estatura y la masa corporal deben ser mayores que cero.");
        }

        // Cálculo del IMC
        double imc = masaCorporal /(estatura*estatura);

        // Retorno del resultado
        return ResponseEntity.ok("Tu IMC es: " + imc);
    }
}
