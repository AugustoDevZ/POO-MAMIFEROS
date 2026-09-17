module org.mineapi.mamiferos {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    // FIX: Added 'to javafx.graphics' so JavaFX can instantiate HelloApplication
    exports org.mineapi.mamiferos to javafx.graphics, javafx.fxml;
    opens org.mineapi.mamiferos to javafx.graphics, javafx.fxml;

    // Keeps your controllers accessible to FXML
    exports org.mineapi.mamiferos.presentation.controller;
    opens org.mineapi.mamiferos.presentation.controller to javafx.fxml;
}