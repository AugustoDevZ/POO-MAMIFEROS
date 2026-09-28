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

import java.io.File;
import java.io.IOException;

public class CardController {
    @FXML protected ImageView imgMamifero;
    @FXML protected Label lblAnimal;
    @FXML protected Label lblTipo;
    private Runnable onClick;

    public void setImage(String path) {

        System.out.println("Imagen solicitada: " + path);

        if (path == null || path.isBlank()) {

            mostrarError(
                    "Error de imagen",
                    "La ruta de la imagen está vacía."
            );

            return;
        }


        try {

            Image imagen;


            /*
             * CASO 1:
             * Imagen interna de resources
             *
             * Ejemplo:
             * /images/Perro/perroDormir1.png
             */
            if (path.startsWith("/")) {

                var resource =
                        getClass().getResource(path);

                if (resource == null) {

                    mostrarError(
                            "Error al cargar imagen",
                            "No se encontró el recurso: " + path
                    );

                    return;
                }

                imagen =
                        new Image(resource.toExternalForm());

            }

            /*
             * CASO 2:
             * Imagen seleccionada desde la computadora
             *
             * Ejemplo:
             * C:\Users\Luis\Pictures\perro.png
             */
            else {

                File archivo =
                        new File(path);

                if (!archivo.exists()) {

                    mostrarError(
                            "Error al cargar imagen",
                            "No existe el archivo: " + path
                    );

                    return;
                }

                imagen =
                        new Image(
                                archivo.toURI().toString()
                        );
            }


            imgMamifero.setImage(imagen);


        } catch (Exception e) {

            mostrarError(
                    "Error al cargar imagen",
                    e.getMessage()
            );
        }
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
