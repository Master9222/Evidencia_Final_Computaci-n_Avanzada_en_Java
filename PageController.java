package com.imc.imc_app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Retorna el nombre del archivo JSP sin la extensión
    }

    @GetMapping("/registro")
    public String showRegistroPage() {
        return "registro"; // Retorna el nombre del archivo JSP sin la extensión
    }

    @GetMapping("/calculo")
    public String showCalculoPage() {
        return "calculo"; // Retorna el nombre del archivo JSP sin la extensión
    }

    @GetMapping("/resultado")
    public String showResultadoPage(Model model) {
        // Aquí puedes agregar lógica para pasar datos al JSP si es necesario
        return "resultado"; // Retorna el nombre del archivo JSP sin la extensión
    }
}
