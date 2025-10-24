package org.uniquindio.edu.co.poo.parcial2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/org/uniquindio/edu/co/poo/parcial2/Dashboard.fxml")
            );
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setTitle("Gestión de Inmuebles - Universidad del Quindío");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(" Error al cargar Principal.fxml. Verifica la ruta del recurso.");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
