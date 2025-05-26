package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.MedicosControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Medico;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;

public class MedicosViewControler {

    App app;
    Administrador administrador;
    MedicosControler controler;
    Medico medicotbl;

    ObservableList<Medico> medicos = FXCollections.observableArrayList();

//------------------------------------------------------------------

    @FXML
    public Button btn_volver;

    @FXML
    public TextField txt_id;

    @FXML
    public TextField txt_nombre;

    @FXML
    public TextField txt_apellido;

    @FXML
    public TextField txt_telefono;

    @FXML
    public Button btn_agregar;

    @FXML
    public Button btn_actualizar;

    @FXML
    public TextField txt_horarioInicio;

    @FXML
    public TextField txt_horarioFin;

    @FXML
    public Button btn_actualizarHorarioMedico;

    @FXML
    public TableView<Medico> tbl_medicos;

    @FXML
    public TableColumn<Medico, String> cln_Nombre;

    @FXML
    public TableColumn<Medico, String> cln_Apellido;

    @FXML
    public TableColumn<Medico, String> cln_Id;

    @FXML
    public TableColumn<Medico, String> cln_Telefono;

    @FXML
    public Button limpiar;

    @FXML
    public Button btn_eliminar;

//------------------------------------------------------------------


    @FXML
    public void volver(){
        app.openViewMenuAdministrador(administrador.getId());
    }

    @FXML
    public void agregarMedico() {
        String nombre = txt_nombre.getText();
        String apellido = txt_apellido.getText();
        String telefono = txt_telefono.getText();
        String id = txt_id.getText();
        if (nombre.isBlank() || apellido.isBlank() || telefono.isBlank() || id.isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese Medico no agregado, datos incorrectos");
        } else {
            Medico medico = new Medico(nombre, apellido, id, telefono, null, null);
            if(!controler.agregarMedico(medico)){
                JOptionPane.showMessageDialog(null, "Medico no agregado, datos incorrectos");
            }
            tbl_medicos.setItems(null);
            initVoid();
        }
    }

    @FXML
    public void actualizarMedico() {
        String id = txt_id.getText();
        if (!id.isBlank()) {
            controler.actualizarMedico(txt_nombre.getText(), txt_apellido.getText(), id, txt_telefono.getText());
        }
        initVoid();
    }

    @FXML
    public void actualizarHorario(){
        String medico = txt_id.getText();
        String horai = txt_horarioInicio.getText();
        String horaf = txt_horarioFin.getText();
        if (!medico.isBlank()){
            controler.setHorario(medico, horai, horaf);
        }
        initVoid();
    }

    @FXML
    public void eliminarMedico() {
        controler.eliminarMedico(administrador, controler.buscarMedico(txt_id.getText()));
        initVoid();
    }

    @FXML
    public void limpiarSeleccion() {
        tbl_medicos.getSelectionModel().clearSelection();
        limpiarCamposMedico();
        tbl_medicos.refresh();
    }



    private void limpiarCamposMedico() {
        txt_id.clear();
        txt_nombre.clear();
        txt_apellido.clear();
        txt_telefono.clear();

    }

    private void initDataBinding(){
        cln_Id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        cln_Telefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        cln_Apellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        cln_Nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
    }

    private void obtenerMedicos() {
        medicos.clear();
        medicos.addAll(controler.getMedicos());
    }

    private void listSelection(){
        tbl_medicos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            medicotbl = newValue;
            mostrarMedico(medicotbl);
        });
    }

    private void mostrarMedico(Medico medicotbl) {
        if (medicotbl != null) {
            txt_id.setText(medicotbl.getId());
            txt_nombre.setText(medicotbl.getNombre());
            txt_apellido.setText(medicotbl.getApellido());
            txt_telefono.setText(medicotbl.getTelefono());
            txt_horarioInicio.setText(medicotbl.getHorarioinicio());
            txt_horarioFin.setText(medicotbl.getHorariofin());
        }
    }

    private void initVoid() { //inincializacion de metodos para la tabla
        tbl_medicos.setItems(null);
        initDataBinding();
        obtenerMedicos();
        tbl_medicos.refresh();
        tbl_medicos.setItems(medicos);
        listSelection();
    }

    public void initialize(){
        controler = new MedicosControler();
    }

    public void setApp(App app, Administrador admin) {
        this.app = app;
        this.administrador = admin;
        initVoid();
    }
}
