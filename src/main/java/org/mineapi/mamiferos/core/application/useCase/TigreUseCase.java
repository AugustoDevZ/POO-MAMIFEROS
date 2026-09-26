package org.mineapi.mamiferos.core.application.useCase;

import org.mineapi.mamiferos.core.application.dto.TigreDto;
import org.mineapi.mamiferos.core.domain.entities.felinos.Tigre;

import java.util.ArrayList;
import java.util.List;

public class TigreUseCase {
    private static List<Tigre> tigreList = new ArrayList<>();

    public static void create(TigreDto dto){

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

        validarFloatPositivo(dto.peso(),"Peso");


        Float tamañoGarras = Float.parseFloat(dto.tamanoGarras());
        Integer velocidad = Integer.parseInt(dto.velocidad());
        Float altura = Float.parseFloat(dto.altura());
        Float largo = Float.parseFloat(dto.largo());
        Float peso = Float.parseFloat(dto.peso());

        var newTigre = new Tigre(
                dto.pathImagePerfil(),
                dto.especieTigre(),
                tamañoGarras,
                velocidad,
                dto.habita(),
                altura,
                largo,
                peso,
                dto.nombreCientifico()
        );
        tigreList.add(newTigre);
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

    public static List<Tigre> getTigreList() {
        return tigreList;
    }
}
