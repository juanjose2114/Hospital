package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.MenuInicioController;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Persona;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MenuInicioViewController {

    public static Persona usuario;
    MenuInicioController menuInicioController;

    private App app;

    @FXML
    private Button btn_iniciarSecion;

    @FXML
    public void initialize(){
        this.app = app;
        menuInicioController = new MenuInicioController();
    }

    @FXML
    public void openIniciarSesion(ActionEvent event){
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
