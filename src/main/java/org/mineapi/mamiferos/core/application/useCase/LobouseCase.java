package org.mineapi.mamiferos.core.application.useCase;

import org.mineapi.mamiferos.core.application.dto.LoboDto;
import org.mineapi.mamiferos.core.domain.entities.caninos.Lobo;
import org.mineapi.mamiferos.core.domain.entities.felinos.Tigre;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LobouseCase {
    private static List<Lobo> loboList = new ArrayList<>();

    public static void create(LoboDto dto){

        Integer numCamada = MamiferoValidateUseCase.isValidInteger(dto.numCamada(), "El número de manada");
        String especieLobo = MamiferoValidateUseCase.isValidText(dto.especieLobo(), "Especie");
        String path = MamiferoValidateUseCase.isValidImagePath(dto.pathImagePerfil());
        String color = MamiferoValidateUseCase.isValidText(dto.color(), "Color");
        Float tamañoColmillos = MamiferoValidateUseCase.isValidColmillos(dto.tamañoColmillos(), 2.0F, 6.0F);
        String habita = MamiferoValidateUseCase.isValidText(dto.habita(), "Hábitat");
        Float altura = MamiferoValidateUseCase.isValidAltura(dto.altura(), 0.60F, 0.90F);
        Float largo = MamiferoValidateUseCase.isValidLargo(dto.largo(), 1.30F, 2.05F);
        Float peso = MamiferoValidateUseCase.isValidPeso(dto.peso(), 23.0F, 80.0F);
        String nombre = MamiferoValidateUseCase.isValidText(dto.nombreCientifico(), "Nombre científico");
        var newLobo = new Lobo(
                numCamada,
                especieLobo,
                path,
                color,
                tamañoColmillos,
                habita,
                altura,
                largo,
                peso,
                nombre
        );

        loboList.add(newLobo);
    }
    public static void generarLoboAleatorio() {
        Random random = new Random();

        String[] especies = {"Gris", "Ártico", "Mexicano"};
        String[] colores = {"Gris", "Blanco", "Negro", "Marrón"};
        String[] habitats = {"Bosque", "Tundra", "Montaña", "Pradera"};
        String[] nombres = {"Akela", "Balto", "Lobo", "Fenrir", "Koda"};

        var newLobo = new Lobo(
                random.nextInt(1, 6),
                especies[random.nextInt(especies.length)],
                "/images/lobo/loboComer03.png",
                colores[random.nextInt(colores.length)],
                random.nextFloat(4.0F, 8.0F),
                habitats[random.nextInt(habitats.length)],
                random.nextFloat(0.6F, 1.0F),
                random.nextFloat(1.0F, 1.8F),
                random.nextFloat(30.0F, 80.0F),
                nombres[random.nextInt(nombres.length)]
        );

        loboList.add(newLobo);
    }

    public static List<Lobo> getLoboList() {
        return loboList;
    }
}
