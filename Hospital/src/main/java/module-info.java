module co.edu.uniquindio.proyecto_ejemplo_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens co.edu.uniquindio.proyecto_ejemplo_javafx to javafx.fxml;
    exports co.edu.uniquindio.proyecto_ejemplo_javafx;

    opens co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;
    exports co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

    opens co.edu.uniquindio.proyecto_ejemplo_javafx.controler;
    exports co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

    opens co.edu.uniquindio.proyecto_ejemplo_javafx.model;
    exports co.edu.uniquindio.proyecto_ejemplo_javafx.model;
}

//clase donde se especifican las rutas de acceso(vista controlador) para el proyecto