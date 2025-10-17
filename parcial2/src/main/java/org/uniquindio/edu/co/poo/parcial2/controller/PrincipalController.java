package org.uniquindio.edu.co.poo.parcial2.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.uniquindio.edu.co.poo.parcial2.App;

public class PrincipalController {

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnListaProductos;

    @FXML
    private Button btnLimpiar;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private void onVerLista() {
        cargarEnContenido("/org.uniquindio.edu.co.poo.parcial2/Dashboard.fxml");
    }

    @FXML
    private void onCrearProducto() {
        cargarEnContenido("/org.uniquindio.edu.co.poo.parcial2/FormularioProducto.fxml");
    }

    @FXML
    private void onLimpiarPantalla() {
        contentPane.getChildren().clear();
    }

    private void cargarEnContenido(String recursoFxml) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(recursoFxml));
            Parent vista = loader.load();

            // Que la vista ocupe todo el contenedor
            AnchorPane.setTopAnchor(vista, 0.0);
            AnchorPane.setRightAnchor(vista, 0.0);
            AnchorPane.setBottomAnchor(vista, 0.0);
            AnchorPane.setLeftAnchor(vista, 0.0);

            contentPane.getChildren().setAll(vista);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,
                    "No se pudo cargar la vista:\n" + recursoFxml + "\n" + e.getMessage())
                    .showAndWait();
        }
    }
}
