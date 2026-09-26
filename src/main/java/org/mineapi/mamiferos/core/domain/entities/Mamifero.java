package org.mineapi.mamiferos.core.domain.entities;

import org.mineapi.mamiferos.core.domain.valueobjets.Accion;

public abstract class Mamifero {
    protected String habita;
    protected Float altura;
    protected Float largo;
    protected Float peso;
    protected String nombreCientifico;
    private String pathImagePerfil;

    protected Mamifero(String pathImagePerfil, String habita, Float altura, Float largo, Float peso, String nombreCientifico) {
        this.habita = habita;
        this.altura = altura;
        this.largo = largo;
        this.peso = peso;
        this.nombreCientifico = nombreCientifico;
        this.pathImagePerfil = pathImagePerfil;
    }

    public abstract Accion comer();
    public abstract Accion dormir();
    public abstract Accion correr();
    public abstract Accion comunicarse();

    public String getPathImagePerfil() {
        return pathImagePerfil;
    }

    public String getHabita() {
        return habita;
    }

    public Float getAltura() {
        return altura;
    }

    public Float getLargo() {
        return largo;
    }

    public Float getPeso() {
        return peso;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }
}
