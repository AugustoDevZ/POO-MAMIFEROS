package org.mineapi.mamiferos.core.application.useCase;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class MamiferoValidateUseCase {
    public static Float isValidGarras(String value, Float minValue, Float maxValue){
        return isValidFloat(value, "garras", minValue, maxValue);
    }
    public static Float isValidAltura(String value, Float minValue, Float maxValue){
        return isValidFloat(value, "altura", minValue, maxValue);
    }
    public static Float isValidLargo(String value, Float minValue, Float maxValue){
        return isValidFloat(value, "largo", minValue, maxValue);
    }
    public static Float isValidPeso(String value, Float minValue, Float maxValue){
        return isValidFloat(value, "peso", minValue, maxValue);
    }


    private static Float isValidFloat(String value, String type, Float minValue, Float maxValue){
        try {

            float num = Float.parseFloat(value);

            if (num <= 0) {
                throw new IllegalArgumentException("El valor ingresado como " +type+" es menor a 0");
            }
            if (num < minValue || num > maxValue){
                throw new IllegalArgumentException("El valor ingresado como " +type+" n oestá en el rango de " + minValue + " a " + maxValue);
            }
            return num;

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("El valor ingresado como " +type+ "no es un número");
        }

    }


    public static Integer isValidVelocidad(String value ,Integer maxValue){
        Integer velocidad  = isValidInteger(value, "La velocidad");
        if (velocidad > maxValue){
            throw new IllegalArgumentException("La velocidad ingresada no es de una animal natural");
        }
        return velocidad;
    }
    private static Integer isValidInteger(String valor, String campo) {

        try {

            int numero = Integer.parseInt(valor);

            if (numero <= 0) {
                throw new IllegalArgumentException(
                        campo + " debe ser mayor que 0."
                );
            }
            return numero;

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(
                    campo + " debe ser un número entero válido."
            );
        }
    }


    public static String isValidText(String valor, String campo) {

        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    campo + " es obligatorio."
            );
        }

        return valor;
    }


    public static String isValidPath(String path) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("La ruta no puede estar vacía");
        }

        try {
            Path filePath = Path.of(path);

            if (!Files.exists(filePath)) {
                throw new IllegalArgumentException("La ruta no existe");
            }

            return filePath.toString();

        } catch (InvalidPathException e) {
            throw new IllegalArgumentException("La ruta no es válida", e);
        }
    }
}
