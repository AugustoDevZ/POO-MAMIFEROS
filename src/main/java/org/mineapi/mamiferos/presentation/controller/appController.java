package org.mineapi.mamiferos.presentation.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.mineapi.mamiferos.core.application.useCase.GuepardoUseCase;
import org.mineapi.mamiferos.core.application.useCase.PerroUseCase;
import org.mineapi.mamiferos.core.application.useCase.TigreUseCase;
import org.mineapi.mamiferos.core.domain.Enum.AccionType;
import org.mineapi.mamiferos.core.domain.entities.Mamifero;
import org.mineapi.mamiferos.core.domain.entities.caninos.Perro;
import org.mineapi.mamiferos.core.domain.entities.felinos.Guepardo;
import org.mineapi.mamiferos.core.domain.entities.felinos.Tigre;
import org.mineapi.mamiferos.core.domain.valueobjets.Accion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class appController {

    @FXML private ScrollPane lstCardContent;
    @FXML private VBox cardContainer;
    @FXML private ImageView imgMamiferoEscenario;
    @FXML private Label lblNombre;
    @FXML private Label lblAccion;
    private Timeline timeline;
    private Timeline timelineFondo;

    private Mamifero actualScene;
    @FXML private ImageView imgEscenario;

    private final List<Image> framesEscenario = new ArrayList<>();
    private int frameActual = 0;



    @FXML protected void initialize(){
        cargarImagesAnimacionEscenario();
        actualScene = null;
        loadOptions();

    }

    private void loadOptions() {



        List<Tigre> tigres =
                TigreUseCase.getTigreList();
        List<Perro> perros =
                PerroUseCase.getPerroList();
        List<Guepardo> guepardos =
                GuepardoUseCase.getGuepardoList();


        cardContainer.getChildren().clear();

        for (Tigre tigre : tigres) {
            cargarCard(tigre);
        }
        for (Perro perro : perros) {
            cargarCard(perro);
        }
        for (Guepardo g : guepardos) {
            cargarCard(g);
        }
    }

    private void cargarCard(Mamifero mamifero) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/org/mineapi/mamiferos/mamifero-card.fxml")
            );

            Parent card = loader.load();

            CardController controller = loader.getController();

            controller.setAnimal(mamifero.getNombreCientifico());
            controller.setTipo(mamifero.getClass().getSimpleName());
            controller.setImage(mamifero.getPathImagePerfil());

            controller.setOnClick(() -> {
                renderizarEscenario(mamifero, AccionType.DORMIR);
            });

            cardContainer.getChildren().add(card);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Accion selectAccionType(Mamifero mamifero, AccionType type){
        switch (type){
            case COMER -> {
                return mamifero.comer();
            }
            case DORMIR -> {
                return mamifero.dormir();
            }
            case CORRER -> {
                return mamifero.correr();
            }
            case COMUNICARSE -> {
                return mamifero.comunicarse();
            }
            default -> {
                return null;
            }
        }
    }

    private void renderizarEscenario(Mamifero mamifero, AccionType type) {

        Accion a = selectAccionType(mamifero, type);

        if (a == null) {
            throw new IllegalArgumentException(
                    "No se obtuvo la acción a realizar"
            );
        }

        actualScene = mamifero;

        lblNombre.setText(mamifero.getNombreCientifico());

        lblAccion.setText(a.getMessage());

        renderizarEscenario(a);
    }

    private void renderizarEscenario(Accion accion) {

        if (timeline != null) {
            timeline.stop();
        }

        String basicPath = accion.getPath();

        List<Image> frames = new ArrayList<>();

        int frame = 1;

        while (true) {

            // Primero intenta encontrar:
            // imagen01.png, imagen02.png, etc.
            String pathConCero =
                    basicPath + String.format("%02d.png", frame);

            var resource =
                    getClass().getResource(pathConCero);


            // Si no existe, intenta:
            // imagen1.png, imagen2.png, etc.
            if (resource == null) {

                String pathSinCero =
                        basicPath + frame + ".png";

                resource =
                        getClass().getResource(pathSinCero);
            }


            // Si no existe ninguno de los dos formatos,
            // significa que terminaron los frames.
            if (resource == null) {
                break;
            }


            frames.add(
                    new Image(resource.toExternalForm())
            );

            frame++;
        }

        if (frames.isEmpty()) {

            mostrarError(
                    "Animación no encontrada",
                    "No se encontraron frames para: "
                            + basicPath
            );

            return;
        }

        System.out.println(frames.size());
        imgMamiferoEscenario.setImage(frames.get(0));

        final int[] indice = {0};

        timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(0.3),
                        event -> {

                            indice[0]++;

                            if (indice[0] >= frames.size()) {
                                indice[0] = 0;
                            }
                            imgMamiferoEscenario.setImage(
                                    frames.get(indice[0])
                            );
                            System.out.println("mostrando imagen "+ indice[0]);
                        }
                )
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void cargarImagesAnimacionEscenario(){
        Thread thread = new Thread(() -> {

            List<Image> images = new ArrayList<>();

            for (int i = 1; i <= 10; i++) {

                Image image = new Image(
                        Objects.requireNonNull(
                                getClass().getResourceAsStream(
                                        "/images/escenario/fondoCorrer" + i + ".png"
                                )
                        )
                );

                images.add(image);
            }

            Platform.runLater(() -> {
                framesEscenario.clear();
                framesEscenario.addAll(images);

                if (!framesEscenario.isEmpty()) {
                    imgEscenario.setImage(framesEscenario.get(0));
                }
            });

        });

        thread.setDaemon(true);
        thread.start();
    }


    @FXML protected void onToggleAnimation(){
        if (timeline != null) {
            timeline.stop();
        }

        if (timelineFondo != null) {
            timelineFondo.stop();
        }
    }

    @FXML protected void onCorrer() {
        if (actualScene == null) return;

        if (framesEscenario.isEmpty()) {
            return;
        }

        onToggleAnimation();

        renderizarEscenario(actualScene, AccionType.CORRER);

        frameActual = 0;

        timelineFondo = new Timeline(
                new KeyFrame(Duration.millis(150), event -> {

                    imgEscenario.setImage(
                            framesEscenario.get(frameActual)
                    );

                    frameActual++;

                    if (frameActual >= framesEscenario.size()) {
                        frameActual = 0;
                    }
                })
        );

        timelineFondo.setCycleCount(Animation.INDEFINITE);
        timelineFondo.play();
    }
    @FXML protected void onDormir() {
        if (actualScene == null) return;
        if (timelineFondo != null) {
            timelineFondo.stop();
        }
        renderizarEscenario(actualScene, AccionType.DORMIR);

    }
    @FXML protected void onComunicarse() {
        if (actualScene == null) return;
        if (timelineFondo != null) {
            timelineFondo.stop();
        }
        renderizarEscenario(actualScene, AccionType.COMUNICARSE);
    }
    @FXML protected void onComer() {
        if (actualScene == null) return;
        if (timelineFondo != null) {
            timelineFondo.stop();
        }
        renderizarEscenario(actualScene, AccionType.COMER);
    }
    @FXML protected void onNuevoMamifero() {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/org/mineapi/mamiferos/nuevo-mamifero.fxml"
                    )
            );

            Parent root = loader.load();

            Stage stage = new Stage();

            stage.setTitle("Nuevo mamífero");
            stage.initModality(Modality.APPLICATION_MODAL);

            Scene scene = new Scene(root);
            stage.setScene(scene);

            double alturaPantalla =
                    Screen.getPrimary().getVisualBounds().getHeight();

            stage.setMaxHeight(alturaPantalla * 0.80);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

        loadOptions();

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
