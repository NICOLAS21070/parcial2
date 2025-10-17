package org.uniquindio.edu.co.poo.parcial2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.uniquindio.edu.co.poo.parcial2.App;
import org.uniquindio.edu.co.poo.parcial2.model.BaseDatosInmuebles;
import org.uniquindio.edu.co.poo.parcial2.model.Inmueble;

import java.io.IOException;

public class DashboardController {

    @FXML private VBox contenedorPrincipal;

    @FXML private TableView<Inmueble> tablaInmuebles;
    @FXML private TableColumn<Inmueble, String> colTipo;
    @FXML private TableColumn<Inmueble, String> colCiudad;
    @FXML private TableColumn<Inmueble, Integer> colHabitaciones;
    @FXML private TableColumn<Inmueble, Integer> colPisos;
    @FXML private TableColumn<Inmueble, Double> colPrecio;

    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;

    private final BaseDatosInmuebles bd = BaseDatosInmuebles.getInstancia();
    private ObservableList<Inmueble> listaInmuebles;

    @FXML
    private void initialize() {
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colHabitaciones.setCellValueFactory(new PropertyValueFactory<>("numeroHabitaciones"));
        colPisos.setCellValueFactory(new PropertyValueFactory<>("numeroPisos"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        listaInmuebles = FXCollections.observableArrayList(bd.getListaInmuebles());
        tablaInmuebles.setItems(listaInmuebles);
    }

    // debe estar anotado con @FXML y con esta firma para que FXML lo enlace
    @FXML
    private void onAgregarInmueble() {
        System.out.println("onAgregarInmueble invoked"); // para depuración
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(
                    "/org/uniquindio/edu/co/poo/parcial2/vista/FormularioInmueble.fxml"));
            Parent formulario = loader.load();

            // si el formulario tiene un controlador que necesita referencia al dashboard:
            Object controller = loader.getController();
            try {
                // intenta llamar setDashboardController si existe (evita acoplamiento estricto)
                controller.getClass().getMethod("setDashboardController", DashboardController.class)
                        .invoke(controller, this);
            } catch (NoSuchMethodException ignored) {
                // si no existe, no pasa nada
            }

            contenedorPrincipal.getChildren().clear();
            contenedorPrincipal.getChildren().add(formulario);

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario: " + e.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error inesperado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void onEliminarInmueble() {
        Inmueble sel = tablaInmuebles.getSelectionModel().getSelectedItem();
        if (sel == null) {
            mostrarAlerta("Atención", "Seleccione un inmueble para eliminar", Alert.AlertType.WARNING);
            return;
        }
        bd.eliminarInmueble(sel);
        listaInmuebles.remove(sel);
    }

    public VBox getContenedorPrincipal() {
        return contenedorPrincipal;
    }

    private void mostrarAlerta(String titulo, String msg, Alert.AlertType tipo) {
        Alert a = new Alert(tipo);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
