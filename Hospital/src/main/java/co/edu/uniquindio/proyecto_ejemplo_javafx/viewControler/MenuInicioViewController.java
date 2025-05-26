package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.MenuInicioController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuInicioViewController {

    MenuInicioController menuInicioController;
    App app;

    @FXML
    public Button btn_iniciarSecion;

    @FXML
    public void initialize(){
        menuInicioController = new MenuInicioController();
    }

    @FXML
    public void openIniciarSesion(){
        if(app != null) {
            app.openViewIniciarSesion();
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    public void setApp(App app){
        this.app = app;
    }
}
