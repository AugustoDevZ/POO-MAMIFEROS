package org.mineapi.mamiferos.core.domain.entities.felinos;

import org.mineapi.mamiferos.core.domain.valueobjets.Accion;
import org.mineapi.mamiferos.core.domain.entities.Felino;

public class Leon extends Felino {

    protected Leon(String pathImagePerfil,Float tamañoGarras, Integer velocidad, String habita, Float altura, Float largo, Float peso, String nombreCientifico) {
        super(pathImagePerfil, tamañoGarras, velocidad, habita, altura, largo, peso, nombreCientifico);
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
