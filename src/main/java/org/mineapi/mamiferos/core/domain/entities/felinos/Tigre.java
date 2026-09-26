package org.mineapi.mamiferos.core.domain.entities.felinos;

import org.mineapi.mamiferos.core.domain.valueobjets.Accion;
import org.mineapi.mamiferos.core.domain.entities.Felino;

public class Tigre extends Felino {

    private final Accion comerDto;
    private final Accion dormirDto;
    private final Accion correrDto;
    private final Accion comunicarseDto;
    private String especieTigre;


    public Tigre(String pathImagePerfil, String especieTigre, Float tamañoGarras, Integer velocidad, String habita, Float altura, Float largo, Float peso, String nombreCientifico) {
        super(pathImagePerfil, tamañoGarras, velocidad, habita, altura, largo, peso, nombreCientifico);
        this.especieTigre = especieTigre;
        comerDto = new Accion("/images/tigre/tigreComer", "Mmm que rico està");
        dormirDto = new Accion("/images/tigre/tigreDormir", "Yo estoySoñando .... ");
        correrDto = new Accion("/images/tigre/tigreCorrer", "Correr es bueno para mi salud");
        comunicarseDto =  new Accion("/images/tigre/tigreComunciarse", "Llamo a todos los tigres");
    }

    public String getEspecieTigre() {
        return especieTigre;
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
