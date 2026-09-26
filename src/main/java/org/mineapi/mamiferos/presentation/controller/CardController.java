package org.mineapi.mamiferos.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CardController {
    @FXML protected ImageView imgMamifero;
    @FXML protected Label lblAnimal;
    @FXML protected Label lblTipo;
    private Runnable onClick;

    public void setImage(String path) {

        System.out.println("Imagen solicitada: " + path);

        var resource = getClass().getResource(path);

        if (resource == null) {
            mostrarError("Error al cargar un Card de Sidebar", "No se encontró la imagen: " + path);
        }

        imgMamifero.setImage(
                new Image(resource.toExternalForm())
        );
    }

    public void setAnimal(String animal) {
        lblAnimal.setText(animal);
    }

    public void setTipo(String tipo) {
        lblTipo.setText(tipo);
    }
    public void setOnClick(Runnable onClick) {
        this.onClick = onClick;
    }

    @FXML private void onClick() {

        if (onClick != null) {
            onClick.run();
        }
    }

    private void mostrarError(String titulo, String mensaje) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/org/mineapi/mamiferos/error.fxml"
                    )
            );

            Parent root = loader.load();

            ErrorController controller = loader.getController();
            controller.setTitulo(titulo);
            controller.setMensaje(mensaje);

            Stage stage = new Stage();

            stage.setTitle("Error");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(new Scene(root));

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
