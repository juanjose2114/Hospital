module co.edu.uniquindio.proyecto_ejemplo_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.proyecto_ejemplo_javafx to javafx.fxml;
    exports co.edu.uniquindio.proyecto_ejemplo_javafx;
}

//clase donde se especifican las rutas de acceso(vista controlador) para el proyecto