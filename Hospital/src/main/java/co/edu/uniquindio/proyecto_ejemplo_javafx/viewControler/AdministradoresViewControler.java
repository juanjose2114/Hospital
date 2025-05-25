package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.AdministradoresControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;

public class AdministradoresViewControler {
    App app;
    Administrador administrador;
    AdministradoresControler controler;
    Administrador administradortbl;

    ObservableList<Administrador> administradores = FXCollections.observableArrayList();

//------------------------------------------------------------------------------------

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
    public Button btn_agregar;

    @FXML
    public Button btn_actualizar;

    @FXML
    public TableView<Administrador> tbl_administradores;

    @FXML
    public TableColumn<Administrador, String> cln_nombre;

    @FXML
    public TableColumn<Administrador, String> cln_apellido;

    @FXML
    public TableColumn<Administrador, String> cln_id;

    @FXML
    public TableColumn<Administrador, String> cln_telefono;

    @FXML
    public Button btn_limpiar;

    @FXML
    public Button btn_eliminar;

//------------------------------------------------------------------------------------


    @FXML
    public void volver() {
        app.openViewMenuAdministrador(administrador.getId());
    }

    @FXML
    public void agregar() {
        controler.agregarAdministrador(administrador.getId(), txt_nombre.getText(), txt_apellido.getText(), txt_id.getText(), txt_telefono.getText());
    }

    @FXML
    public void actualizar() {
        String id = txt_id.getText();
        if (!id.isEmpty()) {
            controler.actualizarMedico(txt_nombre.getText(), txt_apellido.getText(), id, txt_telefono.getText());
        }
    }

    @FXML
    public void limpiar() {
        tbl_administradores.getSelectionModel().clearSelection();
        limpiarCampos();
        tbl_administradores.refresh();
    }

    @FXML
    public void eliminar() {
        controler.eliminarAdministrador(txt_id.getText());
    }



    private void limpiarCampos() {
        txt_nombre.clear();
        txt_apellido.clear();
        txt_id.clear();
        txt_telefono.clear();
    }

    private void initDataBinding(){
        cln_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        cln_apellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        cln_id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        cln_telefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
    }

    private void obtenerAdministradores(){
        administradores.clear();
        administradores.addAll(administradores);
    }

    private void listSelection(){
        tbl_administradores.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            administradortbl = newValue;
            mostrarAdministrador(administradortbl);
        });
    }

    private void mostrarAdministrador(Administrador administradortbl){
        if(administradortbl != null){
            txt_nombre.setText(administradortbl.getNombre());
            txt_apellido.setText(administradortbl.getApellido());
            txt_id.setText(administradortbl.getId());
            txt_telefono.setText(administradortbl.getTelefono());
        }
    }

    private void initVoid(){
        tbl_administradores.setItems(null);
        initDataBinding();
        obtenerAdministradores();
        tbl_administradores.refresh();
        tbl_administradores.setItems(administradores);
        listSelection();
    }

    public void initialize(){
        controler = new AdministradoresControler();
    }

    public void setApp(App app, Administrador admin){
        this.app = app;
        this.administrador = admin;
        initVoid();
    }
}
