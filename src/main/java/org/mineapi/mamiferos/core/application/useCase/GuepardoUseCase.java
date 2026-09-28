package org.mineapi.mamiferos.core.application.useCase;

import org.mineapi.mamiferos.core.application.dto.GuepardoDto;
import org.mineapi.mamiferos.core.domain.entities.felinos.Guepardo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuepardoUseCase {
    private static List<Guepardo> guepardoList = new ArrayList<>();

    public static void create(GuepardoDto dto) {

        validarTexto(dto.tamanoGarras(), "Tamaño de garras");
        validarTexto(dto.velocidad(), "Velocidad");
        validarTexto(dto.habita(), "Hábitat");
        validarTexto(dto.altura(), "Altura");
        validarTexto(dto.largo(), "Largo");
        validarTexto(dto.peso(), "Peso");
        validarTexto(dto.nombreCientifico(), "Nombre científico");
        validarTexto(dto.pathImagePerfil(), "Imagen de perfil");

        validarFloatPositivo(dto.tamanoGarras(), "Tamaño de garras");

        validarIntegerPositivo(dto.velocidad(), "Velocidad");

        validarFloatPositivo(dto.altura(), "Altura");

        validarFloatPositivo(dto.largo(), "Largo");

        validarFloatPositivo(dto.peso(), "Peso");


        Float tamañoGarras = Float.parseFloat(dto.tamanoGarras());
        Integer velocidad = Integer.parseInt(dto.velocidad());
        Float altura = Float.parseFloat(dto.altura());
        Float largo = Float.parseFloat(dto.largo());
        Float peso = Float.parseFloat(dto.peso());

        var newGuepardo = new Guepardo(
                dto.pathImagePerfil(),
                tamañoGarras,
                velocidad,
                dto.habita(),
                altura,
                largo,
                peso,
                dto.nombreCientifico()
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

