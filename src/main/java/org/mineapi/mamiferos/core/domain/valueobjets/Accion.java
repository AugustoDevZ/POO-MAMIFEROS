package org.mineapi.mamiferos.core.domain.valueobjets;

public class Accion {
    private String path;
    private String message;

    public Accion(String path, String message) {
        this.path = path;
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }
}
