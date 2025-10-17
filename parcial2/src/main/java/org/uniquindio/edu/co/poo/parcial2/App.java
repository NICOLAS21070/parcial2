package org.uniquindio.edu.co.poo.parcial2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("/org.uniquindio.edu.co.poo.parcial2/Principal.fxml")
        );

        if (fxmlLoader.getLocation() == null) {
            throw new IllegalStateException("❌ No se encontró el archivo FXML: Principal.fxml");
        }

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Parcial 2 - UQ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
