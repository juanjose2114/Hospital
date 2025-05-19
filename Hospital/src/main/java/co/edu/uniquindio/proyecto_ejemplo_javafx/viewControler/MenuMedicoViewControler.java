package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.MenuMedicoControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Medico;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuMedicoViewControler {

    MenuMedicoControler controler;
    static Medico medico;
    private App app;

    @FXML
    private Button btn_volver;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_apellido;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_telefono;

    @FXML
    private Button btn_actualizar;

    @FXML
    private TextField txt_horainicio;

    @FXML
    private TextField txt_horafin;

    @FXML
    private Button btn_modificarhorario;

    @FXML
    private TextField txt_idpacientebuscar;

    @FXML
    private Button btn_buscarHistorial;


    @FXML
    public void volver() {
        if(app != null) {
            app.openViewIniciarSesion();
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void actualizarHorario(){
        if(!txt_horainicio.getText().isEmpty()){
            medico.setHorarioinicio(txt_horainicio.getText());
        }
    }

    @FXML
    public void actualizarDatos(){
        if(!txt_nombre.getText().isEmpty()){
            medico.setNombre(txt_nombre.getText());
        }
        if(!txt_apellido.getText().isEmpty()){
            medico.setApellido(txt_apellido.getText());
        }
        if(!txt_telefono.getText().isEmpty()){
            medico.setTelefono(txt_telefono.getText());
        }
    }

    @FXML
    public void initialize(){
        this.app = app;
        controler = new MenuMedicoControler();
    }

    public void setApp(App app, Medico medico) {
        this.app = app;
        this.medico = medico;
    }
}