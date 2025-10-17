module org.uniquindio.edu.co.poo.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.uniquindio.edu.co.poo.parcial2 to javafx.fxml;
    exports org.uniquindio.edu.co.poo.parcial2;
}