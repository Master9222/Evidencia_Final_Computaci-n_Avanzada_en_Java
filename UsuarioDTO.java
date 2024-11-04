package com.imc.imc_app.domain.dto;

import java.util.List;

public class UsuarioDTO {
    private Integer id;
    private String nombreCompleto;
    private String username;
    private String password; // Puedes incluir la contraseña si la necesitas para ciertos procesos
    private Double estatura;
    private Integer edad;
    private String sexo;
    private List<HistoricoIMCDTO> historicoIMC; // Campo para el historial de IMC

    // Constructor vacío
    public UsuarioDTO() {}

    // Constructor con todos los campos (incluyendo historicoIMC)
    public UsuarioDTO(Integer id, String nombreCompleto, String username, String password, Double estatura, Integer edad, String sexo, List<HistoricoIMCDTO> historicoIMC) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.password = password;
        this.estatura = estatura;
        this.edad = edad;
        this.sexo = sexo;
        this.historicoIMC = historicoIMC; // Inicializa historicoIMC
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<HistoricoIMCDTO> getHistoricoIMC() {
        return historicoIMC;
    }

    public void setHistoricoIMC(List<HistoricoIMCDTO> historicoIMC) {
        this.historicoIMC = historicoIMC;
    }
}
