module parcial2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.uniquindio.edu.co.poo.parcial2.controller to javafx.fxml;
    opens org.uniquindio.edu.co.poo.parcial2.model to javafx.base;
    exports org.uniquindio.edu.co.poo.parcial2;
}
