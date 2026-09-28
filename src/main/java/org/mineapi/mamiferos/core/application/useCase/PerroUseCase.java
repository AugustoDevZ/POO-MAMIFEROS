package org.mineapi.mamiferos.core.application.useCase;

import org.mineapi.mamiferos.core.application.dto.PerroDto;
import org.mineapi.mamiferos.core.domain.entities.caninos.Perro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                MamiferoValidateUseCase.isValidImagePath(
                        dto.pathImagePerfil()
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

    public static void generarPerroAleatorio() {

        if (!perroList.isEmpty()) {
            return;
        }

        Random random = new Random();

        String[] colores = {"Marrón", "Negro", "Blanco", "Dorado"};
        String[] habitats = {"Sabana africana", "Bosque", "Pradera"};
        String[] especies = {"Canis lupus familiaris", "Canis lupus"};

        Perro perro = new Perro(
                "/images/perro/perroDormir01.png",
                colores[random.nextInt(colores.length)],
                random.nextFloat(0.5F, 1.0F),
                habitats[random.nextInt(habitats.length)],
                random.nextFloat(0.5F, 0.9F),
                random.nextFloat(0.8F, 1.2F),
                random.nextFloat(5F, 40F),
                especies[random.nextInt(especies.length)],
                random.nextInt(1, 1000)
        );

        perroList.add(perro);
    }
}