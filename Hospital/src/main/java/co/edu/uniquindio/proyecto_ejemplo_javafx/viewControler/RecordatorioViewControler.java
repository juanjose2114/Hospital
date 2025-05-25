package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.RecordatorioControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;

public class RecordatorioViewControler {

    App app;
    Administrador administrador;
    RecordatorioControler controler;

//------------------------------------------------------------------------

    @FXML
    public Button btn_volver;
    @FXML
    public TextField txt_cantidadavisos;
//------------------------------------------------------------------------

    @FXML
    public void volver(){
        app.openViewMenuAdministrador(administrador.getId());
    }

    public void enviarRecordatorio(){
        txt_cantidadavisos.setText(controler.enviarRecordatorio());
    }

    public void initialize() {
        controler = new RecordatorioControler();
    }

    public void setApp(App app, Administrador admin){
        this.app = app;
        this.administrador = admin;
        enviarRecordatorio();
    }
}
