package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuAdministradorViewControler {

    MenuMedicoViewControler controler;
    Administrador administrador;
    private App app;

    @FXML
    public Button btn_salas;

    @FXML
    public Button btn_medicos;

    @FXML
    public Button btn_pacientes;

    @FXML
    public Button btn_administradores;

    @FXML
    public Button btn_recordatorio;

    @FXML
    public Button btn_reporte;

    @FXML
    public Button btn_volver;

    @FXML
    public void volver(){
        if (app != null){
            app.openViewIniciarSesion();
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void openSalas(){
        if (app != null){
            app.openViewSalas(administrador.getId());
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void openMedicos(){
        if (app != null){
            app.openViewMedicos(administrador.getId());
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void openPacientes(){
        if (app != null){
            app.openViewPacientes(administrador.getId());
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void openAdministradores(){
        if (app != null){
            app.openViewAdministradores(administrador.getId());
        }
        else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void openRecordatorios(){
        if (app != null){
            app.openViewRecordatorio(administrador.getId());
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void openReporte(){
        if (app != null){
            app.openViewReporte(administrador.getId());
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void initialize() {
        controler = new MenuMedicoViewControler();
    }

    public void setApp(App app, Administrador administrador){
        this.app = app;
        this.administrador = administrador;
    }
}
