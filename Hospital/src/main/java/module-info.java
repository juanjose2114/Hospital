module co.edu.uniquindio.proyecto_ejemplo_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.proyecto_ejemplo_javafx to javafx.fxml;
    exports co.edu.uniquindio.proyecto_ejemplo_javafx;
}