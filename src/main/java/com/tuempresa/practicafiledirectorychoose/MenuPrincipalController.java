package com.tuempresa.practicafiledirectorychoose;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {

    @FXML
    private void abrirProyectos(ActionEvent event) {
        cargarVentana("registro-proyectos.fxml", "Registro de Proyectos");
    }

    @FXML
    private void abrirEstudiantes(ActionEvent event) {
        cargarVentana("registro-estudiantes.fxml", "Registro de Estudiantes");
    }

    @FXML
    private void mostrarAcercaDe(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de");
        alert.setHeaderText("Sistema de Registro y Gestión");
        alert.setContentText("Desarrollado para la asignatura de Programación.\nVersión 1.0");
        alert.showAndWait();
    }

    private void cargarVentana(String fxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
