package org.mineapi.mamiferos.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorController {
    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblMensaje;

    public void setTitulo(String titulo) {
        lblTitulo.setText(titulo);
    }

    public void setMensaje(String mensaje) {
        lblMensaje.setText(mensaje);
    }

    @FXML
    protected void onAceptar() {
        Stage stage = (Stage) lblMensaje.getScene().getWindow();
        stage.close();
    }
}
