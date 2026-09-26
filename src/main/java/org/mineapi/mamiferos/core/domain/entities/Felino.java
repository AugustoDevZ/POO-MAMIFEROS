package org.mineapi.mamiferos.core.domain.entities;

public abstract class Felino extends Mamifero {

    protected Float tamañoGarras;
    protected Integer velocidad;

    protected Felino(String pathImagePerfil, Float tamañoGarras, Integer velocidad, String habita, Float altura, Float largo, Float peso, String nombreCientifico) {
        super(pathImagePerfil, habita, altura, largo, peso, nombreCientifico);
        this.tamañoGarras = tamañoGarras;
        this.velocidad = velocidad;
    }

    public Float getTamañoGarras() {
        return tamañoGarras;
    }

    public Integer getVelocidad() {
        return velocidad;
    }
}
