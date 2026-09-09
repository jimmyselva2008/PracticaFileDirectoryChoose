package com.tuempresa.practicafiledirectorychoose;

import com.tuempresa.practicafiledirectorychoose.model.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegistroEstudiantesController {
    @FXML private TextField txtCif;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCarrera;
    @FXML private TextField txtCorreo;

    @FXML private TableView<Estudiante> tblEstudiantes;
    @FXML private TableColumn<Estudiante, String> colCif;
    @FXML private TableColumn<Estudiante, String> colNombre;
    @FXML private TableColumn<Estudiante, String> colCarrera;
    @FXML private TableColumn<Estudiante, String> colCorreo;

    private final ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colCif.setCellValueFactory(new PropertyValueFactory<>("cif"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        tblEstudiantes.setItems(listaEstudiantes);

        // Cargar de registros por defecto
        listaEstudiantes.add(new Estudiante("2101001", "Ana María López", "Ingeniería de Sistemas", "alopez@uam.edu.ni"));
        listaEstudiantes.add(new Estudiante("2101002", "Carlos Eduardo Pérez", "Diseño Gráfico", "cperez@uam.edu.ni"));

        tblEstudiantes.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtCif.setText(newSelection.getCif());
                        txtNombre.setText(newSelection.getNombreCompleto());
                        txtCarrera.setText(newSelection.getCarrera());
                        txtCorreo.setText(newSelection.getCorreo());
                    }
                }
        );

        // ContextMenu para eliminar
        ContextMenu contextMenu = new ContextMenu();
        MenuItem itemEliminar = new MenuItem("Eliminar");
        itemEliminar.setOnAction(e -> {
            Estudiante seleccionado = tblEstudiantes.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                listaEstudiantes.remove(seleccionado);
                limpiarCampos();
            }
        });
        contextMenu.getItems().add(itemEliminar);
        tblEstudiantes.setContextMenu(contextMenu);
    }

    @FXML
    private void guardarRegistro() {
        if (txtCif.getText().isBlank() || txtNombre.getText().isBlank() ||
                txtCarrera.getText().isBlank() || txtCorreo.getText().isBlank()) {
            mostrarAlerta("Campos requeridos", "Por favor llene todos los campos.");
            return;
        }

        Estudiante nuevo = new Estudiante(
                txtCif.getText(),
                txtNombre.getText(),
                txtCarrera.getText(),
                txtCorreo.getText()
        );

        listaEstudiantes.add(nuevo);
        limpiarCampos();
    }

    @FXML
    private void limpiarCampos() {
        txtCif.clear();
        txtNombre.clear();
        txtCarrera.clear();
        txtCorreo.clear();
        tblEstudiantes.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
