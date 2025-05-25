package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.VerOcupantesControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;

public class VerOcupantesViewControler {

    App app;
    Administrador administrador;
    Sala sala;
    Hospital hospital = App.hospital;
    VerOcupantesControler controler;
    Persona personatbl;

    ObservableList<Persona> ocupantes = FXCollections.observableArrayList();


    @FXML
    public Button btn_volver;

    @FXML
    public TextField txt_idsala;

    @FXML
    public TableView<Persona>  tbl_ocupantes;

    @FXML
    public TableColumn<Persona, String> cln_nombreOcupante;

    @FXML
    public TableColumn<Persona, String> cln_idOcupante;

    @FXML
    public TableColumn<Persona, String> cln_cargoOcupante;

    @FXML
    public TextField txt_nombre;

    @FXML
    public TextField txt_apellido;

    @FXML
    public TextField txt_id;

    @FXML
    public TextField txt_telefono;

    @FXML
    public Button btn_actualizarPaciente;

    @FXML
    public Button btn_agregarPaciente;

    @FXML
    public Button btn_sacarPaciente;


    @FXML
    public void volver(){
        app.openViewSalas(administrador.getId());
    }

    @FXML
    public void actualizarPaciente(){
        controler.actualizarPersona(txt_id.getText(), txt_nombre.getText(), txt_apellido.getText(), txt_telefono.getText(), sala.getIdsala());
        initVoid();
    }

    @FXML
    public void agregarPaciente(){
        controler.agregarPersona(txt_id.getText(), sala.getIdsala(), administrador.getId());
        initVoid();
    }

    @FXML
    public void sacarPaciente(){
        controler.sacarPersona(txt_id.getText(), sala.getIdsala());
        initVoid();
    }

    private void initDataBinding(){
        cln_nombreOcupante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        cln_idOcupante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        cln_cargoOcupante.setCellValueFactory(cellData -> new SimpleStringProperty(controler.getInstance(cellData.getValue())));
    }

    private void obtenerPersona(){
        ocupantes.clear();
        ocupantes.addAll(controler.getPersonas(sala.getIdsala()));
    }

    private void listSelection(){
        tbl_ocupantes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            personatbl = newValue;
            mostrarPersona(personatbl);
        });
    }

    private void mostrarPersona(Persona persona){
        if(persona != null){
            txt_nombre.setText(persona.getNombre());
            txt_apellido.setText(persona.getApellido());
            txt_id.setText(persona.getId());
            txt_telefono.setText(persona.getTelefono());
            txt_idsala.setText(sala.getIdsala());
        }
    }


    @FXML
    public void initVoid(){
        tbl_ocupantes.setItems(null);
        initDataBinding();
        obtenerPersona();
        tbl_ocupantes.refresh();
        tbl_ocupantes.setItems(ocupantes);
        listSelection();
    }

    public void initialize(){
        controler = new VerOcupantesControler();
    }

    public void setApp(App app, Administrador admin, Sala sala) {
        this.app = app;
        this.administrador = admin;
        this.sala = sala;
        txt_idsala.setText(sala.getIdsala());
        initVoid();
    }
}
