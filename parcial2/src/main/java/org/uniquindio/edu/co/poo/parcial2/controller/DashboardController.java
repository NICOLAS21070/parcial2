package org.uniquindio.edu.co.poo.parcial2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.uniquindio.edu.co.poo.parcial2.model.*;

import java.text.NumberFormat;
import java.util.Locale;

public class DashboardController {

    @FXML private TableView<Inmueble> tablaInmuebles;
    @FXML private TableColumn<Inmueble, String> colTipo;
    @FXML private TableColumn<Inmueble, String> colCiudad;
    @FXML private TableColumn<Inmueble, Integer> colPisos;
    @FXML private TableColumn<Inmueble, Integer> colHabitaciones;
    @FXML private TableColumn<Inmueble, Double> colPrecio;

    @FXML private TextField txtTipo;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtPisos;
    @FXML private TextField txtHabitaciones;
    @FXML private TextField txtPrecio;

    private ObservableList<Inmueble> listaInmuebles;

    @FXML
    public void initialize() {
        listaInmuebles = FXCollections.observableArrayList(BaseDatosInmuebles.getListaInmuebles());

        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colPisos.setCellValueFactory(new PropertyValueFactory<>("pisos"));
        colHabitaciones.setCellValueFactory(new PropertyValueFactory<>("habitaciones"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        // ✅ Formatear los precios con separadores y decimales
        NumberFormat formatoColombiano = NumberFormat.getNumberInstance(new Locale("es", "CO"));
        formatoColombiano.setMinimumFractionDigits(2);
        formatoColombiano.setMaximumFractionDigits(2);

        colPrecio.setCellFactory(column -> new TableCell<Inmueble, Double>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText("$ " + formatoColombiano.format(item));
                }
            }
        });

        tablaInmuebles.setItems(listaInmuebles);
    }

    @FXML
    private void onAgregarInmueble() {
        try {
            String tipo = txtTipo.getText();
            String ciudad = txtCiudad.getText();
            int pisos = Integer.parseInt(txtPisos.getText());
            int habitaciones = Integer.parseInt(txtHabitaciones.getText());
            double precio = Double.parseDouble(txtPrecio.getText());

            if (tipo.isEmpty() || ciudad.isEmpty()) {
                mostrarAlerta("Campos vacíos", "Por favor llena todos los campos.");
                return;
            }

            Inmueble nuevo = InmuebleFactory.crearInmueble(tipo, ciudad, habitaciones, pisos, precio);

            listaInmuebles.add(nuevo);
            BaseDatosInmuebles.agregarInmueble(nuevo);

            limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "Pisos, habitaciones y precio deben ser números válidos.");
        } catch (Exception e) {
            mostrarAlerta("Error al agregar inmueble", e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void onEliminarInmueble() {
        Inmueble seleccionado = tablaInmuebles.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaInmuebles.remove(seleccionado);
            BaseDatosInmuebles.eliminarInmueble(seleccionado);
        } else {
            mostrarAlerta("Atención", "Selecciona un inmueble para eliminar.");
        }
    }

    private void limpiarCampos() {
        txtTipo.clear();
        txtCiudad.clear();
        txtPisos.clear();
        txtHabitaciones.clear();
        txtPrecio.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
