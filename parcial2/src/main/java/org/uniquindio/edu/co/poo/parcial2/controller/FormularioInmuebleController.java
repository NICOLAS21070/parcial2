package org.uniquindio.edu.co.poo.parcial2.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.parcial2.App;
import org.uniquindio.edu.co.poo.parcial2.model.BaseDatosInmuebles;
import org.uniquindio.edu.co.poo.parcial2.model.Inmueble;
import org.uniquindio.edu.co.poo.parcial2.model.InmuebleFactory;

import java.io.IOException;

public class FormularioInmuebleController {

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtHabitaciones;

    @FXML
    private TextField txtPisos;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    private BaseDatosInmuebles baseDatosInmuebles;
    private DashboardController dashboardController;
    private VBox contenedorPrincipal;

    @FXML
    public void initialize() {
        baseDatosInmuebles = BaseDatosInmuebles.getInstancia();
    }

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
        this.contenedorPrincipal = dashboardController.getContenedorPrincipal();
    }

    @FXML
    private void onGuardarInmueble() {
        if (!validarCampos()) return;

        try {
            String tipo = txtTipo.getText().trim();
            String ciudad = txtCiudad.getText().trim();
            int habitaciones = Integer.parseInt(txtHabitaciones.getText().trim());
            int pisos = Integer.parseInt(txtPisos.getText().trim());
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            // ✅ PATRÓN FACTORY: crea el tipo correcto de Inmueble
            Inmueble nuevoInmueble = InmuebleFactory.crearInmueble(
                    tipo, ciudad, habitaciones, pisos, precio
            );

            // ✅ PATRÓN SINGLETON: se usa la única instancia de la base de datos
            baseDatosInmuebles.agregarInmueble(nuevoInmueble);

            mostrarAlerta("Éxito", "Inmueble agregado correctamente", Alert.AlertType.INFORMATION);
            limpiarCampos();
            volverAlDashboard();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Habitaciones, pisos y precio deben ser valores numéricos válidos",
                    Alert.AlertType.ERROR);
        } catch (IllegalArgumentException e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void onCancelar() {
        volverAlDashboard();
    }

    private void volverAlDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(
                    "/org/uniquindio/edu/co/poo/parcial2/vista/Dashboard.fxml"));
            Parent dashboard = loader.load();

            contenedorPrincipal.getChildren().clear();
            contenedorPrincipal.getChildren().add(dashboard);

        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo volver al Dashboard", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        txtTipo.clear();
        txtCiudad.clear();
        txtHabitaciones.clear();
        txtPisos.clear();
        txtPrecio.clear();
    }

    private boolean validarCampos() {
        if (txtTipo.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El tipo de inmueble es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtCiudad.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "La ciudad es obligatoria", Alert.AlertType.WARNING);
            return false;
        }
        if (txtHabitaciones.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "Debe indicar el número de habitaciones", Alert.AlertType.WARNING);
            return false;
        }
        if (txtPisos.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "Debe indicar el número de pisos", Alert.AlertType.WARNING);
            return false;
        }
        if (txtPrecio.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El precio es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void setStage(Stage stage) {
        // Método opcional (no requerido)
    }
}
