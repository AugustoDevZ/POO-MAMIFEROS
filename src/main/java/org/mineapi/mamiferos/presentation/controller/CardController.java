package org.mineapi.mamiferos.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardController {
    @FXML protected ImageView imgMamifero;
    @FXML protected Label lblAnimal;
    @FXML protected Label lblTipo;
    private Runnable onClick;

    public void setImage(String path) {

        Image image = new Image(
                getClass().getResource(path).toExternalForm()
        );

        imgMamifero.setImage(image);
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
}
