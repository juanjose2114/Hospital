package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.IniciarSesionControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Medico;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Paciente;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Persona;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class IniciarSesionViewControler {

    IniciarSesionControler iniciarSesionControler;
    private App app;


    @FXML
    private Button btn_iniciarSesion;

    @FXML
    private TextField txt_idusuario;

    @FXML
    public void volver(){
        if(app != null){
            app.openViewMenuInicio();
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void iniciarSesion(){
        String id = txt_idusuario.getText();
        if(app != null){
            String cargo = cargoUsuario(id);
            switch (cargo){
                case "Administrador":
                    app.openViewMenuAdministrador(txt_idusuario.getText());
                    break;
                case "Medico":
                    app.openViewMenuMedico(txt_idusuario.getText());
                    break;
                case "Paciente":
                    app.openViewMenuPaciente(txt_idusuario.getText());
                    break;
                default:
                    System.err.println("Error: persona no existe");
                    throw new IllegalStateException("La persona dueña del id ingresado no existe");
            }
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void initialize(){
        this.app = app;
        iniciarSesionControler = new IniciarSesionControler();
    }

    public String cargoUsuario(String id){
        Persona persona = iniciarSesionControler.buscarPersona(id);
        if(persona instanceof Paciente){
            return "Paciente";
        } else if (persona instanceof Medico){
            return "Medico";
        } else if (persona instanceof Administrador){
            return "Administrador";
        }
        return "null";
    }

    public void setApp(App app){
        this.app = app;
    }
}
