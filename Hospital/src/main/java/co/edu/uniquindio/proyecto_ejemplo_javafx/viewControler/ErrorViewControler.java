package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import javafx.fxml.FXML;

import java.awt.*;

public class ErrorViewControler {

    App app;

    @FXML
    private Button btn_volver;

    public void btn_volver(){
        app.openViewMenuInicio();
    }

    public void setApp(App app, String error) {
        this.app = app;


    }
}
