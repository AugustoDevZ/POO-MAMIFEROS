package org.mineapi.mamiferos.core.application.useCase;

import org.mineapi.mamiferos.core.application.dto.PerroDto;
import org.mineapi.mamiferos.core.domain.entities.caninos.Perro;

import java.util.ArrayList;
import java.util.List;

public class PerroUseCase {

    private static final List<Perro> perroList =
            new ArrayList<>();


    public static void create(PerroDto dto) {

        String color =
                MamiferoValidateUseCase.isValidText(
                        dto.color(),
                        "Color"
                );

        Float tamanoColmillos =
                MamiferoValidateUseCase.isValidColmillos(
                        dto.tamanoColmillos(),
                        0.1F,
                        10F
                );

        String habita =
                MamiferoValidateUseCase.isValidText(
                        dto.habita(),
                        "Hábitat"
                );

        Float altura =
                MamiferoValidateUseCase.isValidAltura(
                        dto.altura(),
                        0.20F,
                        2.0F
                );

        Float largo =
                MamiferoValidateUseCase.isValidLargo(
                        dto.largo(),
                        0.30F,
                        3.0F
                );

        Float peso =
                MamiferoValidateUseCase.isValidPeso(
                        dto.peso(),
                        1F,
                        200F
                );

        String nombre =
                MamiferoValidateUseCase.isValidText(
                        dto.nombreCientifico(),
                        "Nombre científico"
                );

        /*
         * IMPORTANTE:
         * Para imágenes internas del proyecto como
         * /images/perro/perroPerfil.png
         * no conviene usar isValidPath(),
         * porque ese método busca una ruta física del disco.
         */
        String path =
                MamiferoValidateUseCase.isValidText(
                        dto.pathImagePerfil(),
                        "Imagen de perfil"
                );

        Integer fuerzaMordida =
                MamiferoValidateUseCase.isValidFuerzaMordida(
                        dto.fuerzaMordidaPsi(),
                        1,
                        1000
                );


        Perro nuevoPerro = new Perro(
                path,
                color,
                tamanoColmillos,
                habita,
                altura,
                largo,
                peso,
                nombre,
                fuerzaMordida
        );


        perroList.add(nuevoPerro);
    }


    public static List<Perro> getPerroList() {
        return perroList;
    }

    public static void cargarPerroPrueba() {

        if (!perroList.isEmpty()) {
            return;
        }

        Perro perro = new Perro(

                "/images/perro/perroPerfil.png",

                "Marrón, negro y blanco",

                3.5F,

                "Sabana africana",

                0.75F,

                1.10F,

                25F,

                "Lycaon pictus",

                317
        );

        perroList.add(perro);
    }
}