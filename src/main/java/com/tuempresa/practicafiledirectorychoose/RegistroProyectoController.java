package com.tuempresa.practicafiledirectorychoose;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class RegistroProyectoController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtResponsable;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtArchivo;
    @FXML
    private TextField txtDirectorio;
    @FXML
    private Button btnArchivo;
    @FXML
    private Button btnDirectorio;

    //OnAction Seleccionar Archivo
    @FXML
    private void seleccionarArchivo(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Archivo");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivo TXT", "*.txt"),
                new FileChooser.ExtensionFilter("Archivo PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Archivo DOCX", "*.docx"),
                new FileChooser.ExtensionFilter("Archivo XLSX", "*.xlsx"));

        File f = fc.showOpenDialog(btnArchivo.getScene().getWindow());

        if (f != null) {
            txtArchivo.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void seleccionarDirectorio(){
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar Directorio");
        dc.setInitialDirectory(new File("C:\\"));
        File f = dc.showDialog(btnDirectorio.getScene().getWindow());

        if (f != null) {
            txtDirectorio.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void guardarRegistro(){
        if(!validarFormulario()){
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmacion");
        confirmacion.setHeaderText("Seguro que quieres guardar el proyecto?");
        confirmacion.setContentText("Proyecto " + txtNombre.getText() + " guardado correctamente");

        Optional<ButtonType> respuesta = confirmacion.showAndWait();
        if(respuesta.isPresent() && respuesta.get() == ButtonType.OK){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Proyecto guardado correctamente");
            alert.setHeaderText("Proyecto guardado correctamente");
            alert.setContentText("Proyecto guardado correctamente");
        }
    }

    private boolean validarFormulario(){
        String nombre = txtNombre.getText();
        String responsable = txtResponsable.getText();
        String descripcion = txtDescripcion.getText();
        String archivo = txtArchivo.getText();
        String directorio = txtDirectorio.getText();
        if(nombre.isEmpty() || responsable.isEmpty() || descripcion.isEmpty() || txtArchivo.getText().isEmpty() || txtDirectorio.getText().isEmpty()){
            showAlert(
                    Alert.AlertType.WARNING,
                    "Datos Incompletos!",
                    "Completa los datos necesarios para proceder"
            );
            return false;
        }
        return true;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void limpiarCampos(){
        txtNombre.clear();
        txtResponsable.clear();
        txtDescripcion.clear();
        txtArchivo.clear();
        txtDirectorio.clear();
    }
}
