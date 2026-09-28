package org.mineapi.mamiferos.core.domain.entities.caninos;

import org.mineapi.mamiferos.core.domain.entities.Canino;
import org.mineapi.mamiferos.core.domain.valueobjets.Accion;

public class Perro extends Canino {

    private final Integer fuerzaMordidaPsi;

    private final Accion comerDto;
    private final Accion dormirDto;
    private final Accion correrDto;
    private final Accion comunicarseDto;

    public Perro(
            String pathImagePerfil,
            String color,
            Float tamañoColmillos,
            String habita,
            Float altura,
            Float largo,
            Float peso,
            String nombreCientifico,
            Integer fuerzaMordidaPsi
    ) {

        super(
                pathImagePerfil,
                color,
                tamañoColmillos,
                habita,
                altura,
                largo,
                peso,
                nombreCientifico
        );

        this.fuerzaMordidaPsi = fuerzaMordidaPsi;


        comerDto = new Accion(
                "/images/Perro/perroComer",
                "El perro salvaje africano come junto a su manada. "
                        + "Su fuerza de mordida es de "
                        + fuerzaMordidaPsi + " PSI."
        );


        dormirDto = new Accion(
                "/images/Perro/perroDormir",
                "El perro salvaje africano de color "
                        + color
                        + " descansa en su hábitat de "
                        + habita + "."
        );


        correrDto = new Accion(
                "/images/Perro/perroCorrer",
                "El perro salvaje africano corre por "
                        + habita
                        + " con su manada."
        );


        comunicarseDto = new Accion(
                "/images/Perro/perroComunicar",
                "El perro salvaje africano se comunica "
                        + "con los miembros de su manada mediante sonidos."
        );
    }


    public Integer getFuerzaMordidaPsi() {
        return fuerzaMordidaPsi;
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