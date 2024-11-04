package com.imc.imc_app.web.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author gerar
 */
@RestController
@RequestMapping("/calculo") // Define la ruta base para este controlador
public class CalculoController {

    @PostMapping // Maneja las solicitudes POST para calcular el IMC
    public ResponseEntity<String> calcularIMC(@RequestParam float estatura, @RequestParam float masaCorporal) {
        // Validación de los valores
        if (estatura <= 0 || masaCorporal <= 0) {
            return ResponseEntity.badRequest().body("La estatura y la masa corporal deben ser mayores que cero.");
        }

        // Cálculo del IMC
          float imc = masaCorporal /(estatura*estatura);

        // Devuelve el resultado como parte de la respuesta
        return ResponseEntity.ok("El IMC calculado es: " + imc);
    }
}
