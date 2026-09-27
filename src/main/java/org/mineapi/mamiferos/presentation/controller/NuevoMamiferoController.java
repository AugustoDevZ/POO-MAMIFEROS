package org.mineapi.mamiferos.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.mineapi.mamiferos.core.application.dto.PerroDto;
import org.mineapi.mamiferos.core.application.dto.TigreDto;
import org.mineapi.mamiferos.core.application.useCase.PerroUseCase;
import org.mineapi.mamiferos.core.application.useCase.TigreUseCase;
import org.mineapi.mamiferos.core.domain.entities.Mamifero;
import org.mineapi.mamiferos.core.domain.entities.caninos.Lobo;
import org.mineapi.mamiferos.core.domain.entities.caninos.Perro;
import org.mineapi.mamiferos.core.domain.entities.felinos.Guepardo;
import org.mineapi.mamiferos.core.domain.entities.felinos.Leon;
import org.mineapi.mamiferos.core.domain.entities.felinos.Tigre;

import java.io.File;
import java.io.IOException;

public class NuevoMamiferoController {

    @FXML private VBox felinoSection;
    @FXML private VBox caninoSection;
    @FXML private Label lblCanino, lblCanino2;
    @FXML
    private TextField txtCanino2, txtCanino;

    @FXML
    private TextField txtColorCanino;

    @FXML
    private TextField txtTamañoColmillosCanino;
    @FXML private Label lblFelino, lblFelino2;
    @FXML private TextField txtFelino2, txtFelino;
    @FXML private ComboBox<String> cmbTipo;
    @FXML private ComboBox<String> cmbAnimal;
    @FXML private TextField txtNombreCientifico, txtHabita, txtAltura, txtLargo, txtPeso, txtPathImagePerfil;
    @FXML private TextField txtTamanoGarras, txtVelocidad;
    @FXML private Button btnCrearMami;
    @FXML
    private void initialize() {
        cmbTipo.getItems().addAll("Felino", "Canino");


        cmbTipo.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, nuevo) -> {

                    cmbAnimal.getItems().clear();

                    if ("Felino".equals(nuevo)) {
                        cmbAnimal.getItems().addAll(
                                "León",
                                "Tigre",
                                "Guepardo"
                        );
                        mostrarFelino();
                    }

                    if ("Canino".equals(nuevo)) {
                        cmbAnimal.getItems().addAll(
                                "Lobo",
                                "Perro"
                        );
                        mostrarCanino();
                    }
                }
        );


        cmbAnimal.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, nuevo) -> {

                    lblFelino.setVisible(true);
                    txtFelino.setVisible(true);
                    lblFelino2.setVisible(true);
                    txtFelino2.setVisible(true);
                    lblCanino.setVisible(true);
                    txtCanino.setVisible(true);
                    lblCanino2.setVisible(true);
                    txtCanino2.setVisible(true);

                    if ("Perro".equals(nuevo)) {
                        lblCanino.setText("Fuerza de mordidad");
                        txtCanino.setPromptText("5");
                        lblCanino2.setVisible(false);
                        txtCanino2.setVisible(false);
                    }

                    if ("Lobo".equals(nuevo)) {
                        lblCanino.setText("Numero de camada");
                        txtCanino.setPromptText("20");
                        lblCanino2.setText("Tipo de especie");
                        txtCanino2.setPromptText("20");
                    }

                    if ("León".equals(nuevo)) {
                        lblFelino.setText("Numero de manada");
                        txtFelino.setPromptText("20");
                        lblFelino2.setText("potencia de rugido en decibel");
                        txtFelino2.setPromptText("20");
                    }
                    if ("Tigre".equals(nuevo)) {
                        lblFelino.setText("Especie de tigre");
                        txtFelino.setPromptText("Pantera Rosa");
                        lblFelino2.setVisible(false);
                        txtFelino2.setVisible(false);
                    }
                    if ("Guepardo".equals(nuevo)) {
                        lblFelino.setVisible(false);
                        txtFelino.setVisible(false);
                        lblFelino2.setVisible(false);
                        txtFelino2.setVisible(false);
                    }
                }
        );
    }
    private void mostrarFelino() {

        felinoSection.setVisible(true);
        felinoSection.setManaged(true);

        caninoSection.setVisible(false);
        caninoSection.setManaged(false);
    }

    private void mostrarCanino() {

        felinoSection.setVisible(false);
        felinoSection.setManaged(false);

        caninoSection.setVisible(true);
        caninoSection.setManaged(true);
    }

    @FXML private void onCreateRandom(){

    }
    @FXML private void onCancelar(){

    }
    @FXML private void onCrear(){
        int tipoMamifero = cmbTipo.getSelectionModel().getSelectedIndex();
        if (tipoMamifero == -1 || cmbAnimal.getSelectionModel().getSelectedIndex() == -1){
            mostrarError("Debes rellenar lso campos", "Para poder crear un nuevo mamifero debes rellenar todos los campo o hacer clic en random.");
            return;
        }

        String nombre = txtNombreCientifico.getText();
        String habita = txtHabita.getText();
        String altura = txtAltura.getText();
        String largo = txtLargo.getText();
        String peso = txtPeso.getText();
        String path = txtPathImagePerfil.getText();
        String animal = cmbAnimal.getValue();


        switch (animal) {
            case "León" -> {

            }
            case "Tigre" -> {

                var newTigre = new TigreDto(
                        txtTamanoGarras.getText(),
                        txtVelocidad.getText(),
                        habita,
                        altura,
                        largo,
                        peso,
                        nombre,
                        path,
                        txtFelino.getText()
                );
                try {
                  TigreUseCase.create(newTigre);
                }catch (IllegalArgumentException e){
                    mostrarError("Datos inválidos" + nombre, e.getMessage());
                }
            }
            case "Guepardo" -> {


            }
            case "Lobo" -> {


            }

            case "Perro" -> {

                PerroDto nuevoPerro = new PerroDto(

                        txtColorCanino.getText(),

                        txtTamañoColmillosCanino.getText(),

                        habita,
                        altura,
                        largo,
                        peso,

                        nombre,
                        path,

                        txtCanino.getText()
                );


                try {

                    PerroUseCase.create(nuevoPerro);

                } catch (IllegalArgumentException e) {

                    mostrarError(
                            "Datos inválidos - " + nombre,
                            e.getMessage()
                    );

                    return;
                }
            }

        };

        Stage stage = (Stage) btnCrearMami.getScene().getWindow();
        stage.close();

    }

    @FXML private void onTipoChanged(){

    }
    @FXML private void onAnimalChanged(){

    }
    @FXML private void onSeleccionarImagen(){
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Seleccionar imagen");

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Imágenes",
                        "*.png",
                        "*.jpg",
                        "*.jpeg"
                )
        );

        Stage stage = (Stage) txtPathImagePerfil.getScene().getWindow();

        File archivo = fileChooser.showOpenDialog(stage);

        if (archivo != null) {
            txtPathImagePerfil.setText(archivo.getAbsolutePath());
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
