module com.javafxpro {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.javafxpro to javafx.fxml;
    exports com.javafxpro;
    exports com.javafxpro.classes;
    opens com.javafxpro.classes to javafx.fxml;
    exports com.javafxpro.controller;
    opens com.javafxpro.controller to javafx.fxml;


}