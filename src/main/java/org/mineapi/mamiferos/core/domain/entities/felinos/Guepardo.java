package org.mineapi.mamiferos.core.domain.entities.felinos;

import org.mineapi.mamiferos.core.domain.valueobjets.Accion;
import org.mineapi.mamiferos.core.domain.entities.Felino;

public class Guepardo extends Felino {
    private final Accion comerDto;
    private final Accion dormirDto;
    private final Accion correrDto;
    private final Accion comunicarseDto;

    public Guepardo(String pathImagePerfil, Float tamañoGarras, Integer velocidad, String habita, Float altura, Float largo, Float peso, String nombreCientifico) {
        super(pathImagePerfil, tamañoGarras, velocidad, habita, altura, largo, peso, nombreCientifico);
        comerDto = new Accion("/images/guepardo/Guepardocomer", "Mmm que rico està");
        dormirDto = new Accion("/images/guepardo/Guepardodormir", "Yo estoySoñando .... ");
        correrDto = new Accion("/images/guepardo/Guepardocorrer", "Correr es bueno para mi salud");
        comunicarseDto = new Accion("/images/guepardo/Guepardocomunicar", "Llamo a todos los guepardos");
    }

    @Override
    public Accion comer() {
        return comerDto;
    }

    @Override
    public Accion dormir() {
        return dormirDto;
    }

    @Override
    public Accion correr() {
        return correrDto;
    }

    @Override
    public Accion comunicarse() {
        return comunicarseDto;
    }
}
