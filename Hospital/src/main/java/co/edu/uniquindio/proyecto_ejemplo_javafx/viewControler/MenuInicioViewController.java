package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.MenuInicioController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuInicioViewControler {

    MenuInicioController menuInicioController;

    @FXML
    private Button btn_iniciarSecion;

    @FXML
    private App app;

    @FXML
    public void initialize(){
        this.app = app;
        menuInicioController = new MenuInicioController(app.hospital);
    }

    public void configurarBotones() {}


    public void setApp(App app){
        this.app = app;
    }
}
