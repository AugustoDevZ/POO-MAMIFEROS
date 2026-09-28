package org.mineapi.mamiferos.core.domain.entities.caninos;

import org.mineapi.mamiferos.core.domain.valueobjets.Accion;
import org.mineapi.mamiferos.core.domain.entities.Canino;

public class Lobo extends Canino {
    private final Accion comerDto;
    private final Accion dormirDto;
    private final Accion correrDto;
    private final Accion comunicarseDto;
    private Integer numCamada;
    private String especieLobo;

    protected Lobo(Integer numCamada, String especieLobo, String pathImagePerfil, String color, Float tamañoColmillos, String habita, Float altura, Float largo, Float peso, String nombreCientifico) {
        super(pathImagePerfil, color, tamañoColmillos, habita, altura, largo, peso, nombreCientifico);
        comerDto = new Accion("/images/tigre/tigreComer", "Mmm que rico està");
        dormirDto = new Accion("/images/tigre/tigreDormir", "Yo estoySoñando .... ");
        correrDto = new Accion("/images/tigre/tigreCorrer", "Correr es bueno para mi salud");
        comunicarseDto =  new Accion("/images/tigre/tigreComunciarse", "Llamo a todos los perros");
        this.numCamada =numCamada;
        this. especieLobo =  especieLobo;

    }

    public String getEspecieLobo() {
        return especieLobo;
    }

    public Integer getNumCamada() {
        return numCamada;
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
