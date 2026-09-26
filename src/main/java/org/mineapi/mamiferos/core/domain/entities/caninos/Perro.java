package org.mineapi.mamiferos.core.domain.entities.caninos;

import org.mineapi.mamiferos.core.domain.valueobjets.Accion;
import org.mineapi.mamiferos.core.domain.entities.Canino;

public class Perro extends Canino {
    protected Perro(String pathImagePerfil, String color, Float tamañoColmillos, String habita, Float altura, Float largo, Float peso, String nombreCientifico) {
        super(pathImagePerfil, color, tamañoColmillos, habita, altura, largo, peso, nombreCientifico);
    }


    @Override
    public Accion comer() {
        return null;
    }

    @Override
    public Accion dormir() {
        return null;
    }

    @Override
    public Accion correr() {
        return null;
    }

    @Override
    public Accion comunicarse() {
        return null;
    }
}
