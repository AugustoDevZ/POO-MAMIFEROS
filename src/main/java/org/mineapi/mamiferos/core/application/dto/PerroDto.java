package org.mineapi.mamiferos.core.application.dto;

public record PerroDto(

        String color,
        String tamanoColmillos,

        String habita,
        String altura,
        String largo,
        String peso,

        String nombreCientifico,
        String pathImagePerfil,

        String fuerzaMordidaPsi

) {
}