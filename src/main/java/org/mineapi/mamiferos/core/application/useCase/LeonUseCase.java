/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mineapi.mamiferos.core.application.useCase;

import org.mineapi.mamiferos.core.application.dto.LeonDto;
import org.mineapi.mamiferos.core.domain.entities.felinos.Leon;
import org.mineapi.mamiferos.core.domain.entities.felinos.Tigre;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author USUARIO
 */
public class LeonUseCase {
    private static List<Leon> leonList = new ArrayList<>();

    public static void create(LeonDto dto){
        Integer numManada=MamiferoValidateUseCase.isValidInteger(dto.numManada(),"Manada");
        Float potenciaRugidoDecibel=MamiferoValidateUseCase.isValidLargo(dto.potenciaRugidoDecibel(),80F,114F);
        String path=MamiferoValidateUseCase.isValidImagePath(dto.pathImagePerfil());
        Float tamañoGarras=MamiferoValidateUseCase.isValidGarras(dto.tamanoGarras(),0.1F,10F);
        Integer velocidad=MamiferoValidateUseCase.isValidVelocidad(dto.velocidad(),80);
        String habita=MamiferoValidateUseCase.isValidText(dto.habita(),"Hábitat");
        Float altura=MamiferoValidateUseCase.isValidAltura(dto.altura(),0.8F,1.2F);
        Float largo=MamiferoValidateUseCase.isValidLargo(dto.largo(),1.4F,2.5F);
        Float peso=MamiferoValidateUseCase.isValidPeso(dto.peso(),80F,250F);
        String nombre=MamiferoValidateUseCase.isValidText(dto.nombreCientifico(),"Nombre científico");
        var newLeon=new Leon(numManada,potenciaRugidoDecibel,path,tamañoGarras,velocidad,habita,altura,largo,peso,nombre);
        leonList.add(newLeon);
    }

    public static List<Leon> getLeonList() {
        return leonList;
    }

    public static void generarLeonAleatorio(){
        Random random=new Random();
        String[] habitats={"Sabana africana","Pradera","Bosque abierto"};
        String[] nombres={"Simba","Mufasa","Scar","Kovu","Leo","Aslan"};
        var newLeon=new Leon(
                3+random.nextInt(17),
                90F+random.nextFloat()*24F,
                "/images/leon/leonComer01.png",
                5F+random.nextFloat()*4F,
                50+random.nextInt(31),
                habitats[random.nextInt(habitats.length)],
                0.9F+random.nextFloat()*0.3F,
                1.7F+random.nextFloat()*0.8F,
                120F+random.nextFloat()*130F,
                nombres[random.nextInt(nombres.length)]
        );
        leonList.add(newLeon);
    }
}
