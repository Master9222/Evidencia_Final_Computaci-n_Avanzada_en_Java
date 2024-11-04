package com.imc.imc_app.domain.dto;


public class CalculoIMCDTO {
    private float estatura; // En metros
    private float masaCorporal; // En kilogramos

    // Getters y Setters
    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getMasaCorporal() {
        return masaCorporal;
    }

    public void setMasaCorporal(float masaCorporal) {
        this.masaCorporal = masaCorporal;
    }
}

