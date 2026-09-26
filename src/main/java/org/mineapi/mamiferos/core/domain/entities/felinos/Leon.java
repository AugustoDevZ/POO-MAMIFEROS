package org.mineapi.mamiferos.core.domain.entities.felinos;

import org.mineapi.mamiferos.core.domain.valueobjets.Accion;
import org.mineapi.mamiferos.core.domain.entities.Felino;

public class Leon extends Felino {
    private final Accion comerDto;
    private final Accion dormirDto;
    private final Accion correrDto;
    private final Accion comunicarseDto;
    private Float potenciaRugidoDecibel;
    private Integer numManada;

    protected Leon(Integer numManada, Float potenciaRugidoDecibel,String pathImagePerfil,Float tamañoGarras, Integer velocidad, String habita, Float altura, Float largo, Float peso, String nombreCientifico) {
        super(pathImagePerfil, tamañoGarras, velocidad, habita, altura, largo, peso, nombreCientifico);
        comerDto = new Accion("/images/tigre/tigreComer", "Mmm que rico està");
        dormirDto = new Accion("/images/tigre/tigreDormir", "Yo estoySoñando .... ");
        correrDto = new Accion("/images/tigre/tigreCorrer", "Correr es bueno para mi salud");
        comunicarseDto =  new Accion("/images/tigre/tigreComunciarse", "Llamo a todos los tigres");
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
        this.numManada =numManada;
    }

    public Integer getNumManada() {
        return numManada;
    }

    public Float getPotenciaRugidoDecibel() {
        return potenciaRugidoDecibel;
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
