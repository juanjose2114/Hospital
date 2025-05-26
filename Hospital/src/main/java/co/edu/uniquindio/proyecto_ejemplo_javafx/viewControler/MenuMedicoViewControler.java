package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.MenuMedicoControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Medico;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuMedicoViewControler {

    MenuMedicoControler controler;
    Medico medico;
    App app;

//----------------------------------------------------------------------------------------------------------------------

    @FXML
    public Button btn_volver;

    @FXML
    public TextField txt_nombre;

    @FXML
    public TextField txt_apellido;

    @FXML
    public TextField txt_id;

    @FXML
    public TextField txt_telefono;

    @FXML
    public Button btn_actualizar;

    @FXML
    public TextField txt_horainicio;

    @FXML
    public TextField txt_horafin;

    @FXML
    public Button btn_modificarhorario;

    @FXML
    public TextField txt_idpacientebuscar;

    @FXML
    public Button btn_buscarHistorial;

//----------------------------------------------------------------------------------------------------------------------

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
    public void revizarPaciente(){
        if(!txt_idpacientebuscar.getText().isEmpty()){
            app.openViewRevizarPaciente(medico.getId(), txt_idpacientebuscar.getText());
        }
    }

    @FXML
    public void actualizarHorario(){
        if(!txt_horainicio.getText().isEmpty()){
            medico.setHorarioinicio(txt_horainicio.getText());
        }
        if(!txt_horafin.getText().isEmpty()){
            medico.setHorariofin(txt_horafin.getText());
        }
        initVoid();
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
        initVoid();
    }



    private void initVoid(){
        txt_nombre.setText(medico.getNombre());
        txt_apellido.setText(medico.getApellido());
        txt_id.setText(medico.getId());
        txt_telefono.setText(medico.getTelefono());
        txt_horainicio.setText(medico.getHorarioinicio());
        txt_horafin.setText(medico.getHorariofin());
    }

    @FXML
    public void initialize(){
        controler = new MenuMedicoControler();
    }

    public void setApp(App app, Medico medico) {
        this.app = app;
        this.medico = medico;
        initVoid();
    }
}