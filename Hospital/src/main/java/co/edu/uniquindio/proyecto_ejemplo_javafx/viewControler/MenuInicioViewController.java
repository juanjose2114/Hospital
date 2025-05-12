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

    @FXML
    private Button btn_iniciarSecion;

    @FXML
    private Button btn_registrarse;

    @FXML
    private App app;

    @FXML
    public void initialize(){
        this.app = app;
        menuInicioController = new MenuInicioController(app.hospital);
    }

    public void configurarBotones() {
        btn_iniciarSecion.setOnAction(this::iniciarSesion);
    }

    public void iniciarSesion(ActionEvent event) {
        App.launch("IniciarSesion");
    }

    public void registrarse(ActionEvent event) {
        App.launch("Registrarse");
    }

    public void setApp(App app){
        this.app = app;
    }
}
