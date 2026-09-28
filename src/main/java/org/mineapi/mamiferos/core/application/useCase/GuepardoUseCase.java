package org.mineapi.mamiferos.core.application.useCase;

import org.mineapi.mamiferos.core.application.dto.GuepardoDto;
import org.mineapi.mamiferos.core.domain.entities.felinos.Guepardo;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Guepardo> getGuepardoList() {
        return guepardoList;
    }
}