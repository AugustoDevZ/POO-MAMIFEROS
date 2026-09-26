package org.mineapi.mamiferos.core.domain.entities;

public abstract class Canino extends Mamifero{
    protected String color;
    protected Float tamañoColmillos;

    protected Canino(String pathImagePerfil, String color, Float tamañoColmillos,String habita, Float altura, Float largo, Float peso, String nombreCientifico) {
        super(pathImagePerfil, habita, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamañoColmillos = tamañoColmillos;
    }

    public String getColor() {
        return color;
    }

    public Float getTamañoColmillos() {
        return tamañoColmillos;
    }
}
