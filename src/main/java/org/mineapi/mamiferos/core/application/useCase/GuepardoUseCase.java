package org.mineapi.mamiferos.core.application.useCase;

import org.mineapi.mamiferos.core.application.dto.GuepardoDto;
import org.mineapi.mamiferos.core.domain.entities.felinos.Guepardo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuepardoUseCase {
    private static final List<Guepardo> guepardoList = new ArrayList<>();

    public static void create(GuepardoDto dto) {

        Float tamanoGarras = MamiferoValidateUseCase.isValidGarras(dto.tamanoGarras(), 0.1F, 10F);
        Integer velocidad = MamiferoValidateUseCase.isValidVelocidad(dto.velocidad(), 130);
        String habita = MamiferoValidateUseCase.isValidText(dto.habita(), "Hábitat");
        Float altura = MamiferoValidateUseCase.isValidAltura(dto.altura(), 0.30F, 1.10F);
        Float largo = MamiferoValidateUseCase.isValidLargo(dto.largo(), 0.40F, 2.4F);
        Float peso = MamiferoValidateUseCase.isValidPeso(dto.peso(), 1.0F, 80.0F);
        String nombre = MamiferoValidateUseCase.isValidText(dto.nombreCientifico(), "Nombre científico");
        String path = MamiferoValidateUseCase.isValidText(dto.pathImagePerfil(), "Imagen de perfil");

        var newGuepardo = new Guepardo(
                path,
                tamanoGarras,
                velocidad,
                habita,
                altura,
                largo,
                peso,
                nombre
        );
        guepardoList.add(newGuepardo);
    }


    private static void validarTexto(String valor, String campo) {

        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    campo + " es obligatorio."
            );
        }
    }

    private static void validarFloatPositivo(String valor, String campo) {

        try {

            float numero = Float.parseFloat(valor);

            if (numero <= 0) {
                throw new IllegalArgumentException(
                        campo + " debe ser mayor que 0."
                );
            }

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(
                    campo + " debe ser un número válido."
            );
        }
    }

    private static void validarIntegerPositivo(String valor, String campo) {

        try {

            int numero = Integer.parseInt(valor);

            if (numero <= 0) {
                throw new IllegalArgumentException(
                        campo + " debe ser mayor que 0."
                );
            }

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(
                    campo + " debe ser un número entero válido."
            );
        }
    }
    public static void generarGuepardoAleatorio() {

        Random random = new Random();

        String[] habitats = {
                "Sabana africana",
                "Pradera",
                "Zonas semiáridas"
        };

        var newGuepa = new Guepardo(
                "/images/guepardo/Guepardocomer01.png",
                random.nextFloat(5.0F, 10.0F),
                random.nextInt(80, 121),
                habitats[random.nextInt(habitats.length)],
                random.nextFloat(0.7F, 0.9F),
                random.nextFloat(1.1F, 1.5F),
                random.nextFloat(30.0F, 60.0F),
                "Acinonyx jubatus"
        );
        guepardoList.add(newGuepa);
    }
    public static List<Guepardo> getGuepardoList() {
        return guepardoList;
    }
}