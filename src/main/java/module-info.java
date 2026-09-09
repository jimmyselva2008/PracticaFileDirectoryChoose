module com.tuempresa.practicafiledirectorychoose {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tuempresa.practicafiledirectorychoose.model to javafx.base;
    opens com.tuempresa.practicafiledirectorychoose to javafx.fxml;
    exports com.tuempresa.practicafiledirectorychoose;
}