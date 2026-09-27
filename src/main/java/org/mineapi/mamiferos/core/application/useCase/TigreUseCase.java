package org.mineapi.mamiferos.core.application.useCase;

import org.mineapi.mamiferos.core.application.dto.TigreDto;
import org.mineapi.mamiferos.core.domain.entities.Mamifero;
import org.mineapi.mamiferos.core.domain.entities.felinos.Tigre;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TigreUseCase {
    private static List<Tigre> tigreList = new ArrayList<>();

    public static void create(TigreDto dto){

        Float tamanoGarras = MamiferoValidateUseCase.isValidGarras(dto.tamanoGarras(), 0.1F, 10F);
        Integer velocidad = MamiferoValidateUseCase.isValidVelocidad(dto.velocidad(), 64);
        String habita = MamiferoValidateUseCase.isValidText(dto.habita(), "Hábitat");
        Float altura = MamiferoValidateUseCase.isValidAltura(dto.altura(), 0.12F, 1.22F);
        Float largo = MamiferoValidateUseCase.isValidLargo(dto.largo(), 0.30F, 3.8F);
        Float peso = MamiferoValidateUseCase.isValidPeso(dto.peso(), 1.0F, 320.0F);
        String nombre = MamiferoValidateUseCase.isValidText(dto.nombreCientifico(), "Nombre científico");
        String path = MamiferoValidateUseCase.isValidImagePath(dto.pathImagePerfil());
        String especie = MamiferoValidateUseCase.isValidText(dto.especieTigre(), "Especie");

        var newTigre = new Tigre(
                path,
                especie,
                tamanoGarras ,
                velocidad,
                habita,
                altura,
                largo,
                peso,
                nombre
        );
        tigreList.add(newTigre);
    }



    public static List<Tigre> getTigreList() {
        return tigreList;
    }
}
