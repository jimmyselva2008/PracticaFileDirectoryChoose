package com.tuempresa.practicafiledirectorychoose;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-principal.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Bienvenido al menu principal");
        stage.setScene(scene);
        stage.show();

    }
}
