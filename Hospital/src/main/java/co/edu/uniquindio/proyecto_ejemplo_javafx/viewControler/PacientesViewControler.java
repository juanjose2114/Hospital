package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.PacientesControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class PacientesViewControler {

    App app;
    Administrador administrador;
    PacientesControler controler;

    Paciente pacientetbl;

    ObservableList<Paciente> pacientes = FXCollections.observableArrayList();


//-----------------------------------------------------------------------------

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
    public Button btn_eliminar;

    @FXML
    public TableView<Paciente> tbl_pacientes;

    @FXML
    public TableColumn<Paciente, String> cln_nombre;

    @FXML
    public TableColumn<Paciente, String> cln_apellido;

    @FXML
    public TableColumn<Paciente, String> cln_id;

    @FXML
    public TableColumn<Paciente, String> cln_telefono;

    @FXML
    public Button btn_limpiar;

//-----------------------------------------------------------------------------

    @FXML
    public void volver() {
        app.openViewMenuAdministrador(administrador.getId());
    }

    @FXML
    public void agregarPaciente() {
        if (!txt_nombre.getText().isBlank() && !txt_apellido.getText().isBlank() && !txt_id.getText().isBlank() && !txt_telefono.getText().isBlank()) {
            controler.agregarPaciente(administrador.getId(), txt_nombre.getText(), txt_apellido.getText(), txt_id.getText(), txt_telefono.getText());
        }
        initVoid();
    }

    @FXML
    public void actualizarPaciente() {
        if (!txt_id.getText().isBlank()){
            if (!txt_nombre.getText().isBlank()){
                System.out.println("1");
                controler.setNombre(txt_id.getText(), txt_nombre.getText());
            }
            if (!txt_apellido.getText().isBlank()){
                System.out.println("2");
                controler.setApellido(txt_id.getText(), txt_apellido.getText());
            }
            if (!txt_telefono.getText().isBlank()){
                System.out.println("3");
                controler.setTelefono(txt_id.getText(), txt_telefono.getText());
            }
        }
        initVoid();
    }

    @FXML
    public void eliminarPaciente() {
        controler.eliminarPaciente(administrador.getId(), txt_id.getText());
        initVoid();
    }

    @FXML
    public void limpiar() {
        tbl_pacientes.getSelectionModel().clearSelection();
        limpiarCampos();
        tbl_pacientes.refresh();
    }



    private void limpiarCampos() {
        txt_nombre.clear();
        txt_apellido.clear();
        txt_id.clear();
        txt_telefono.clear();
        initVoid();
    }

    private void initDataBinding(){
        cln_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        cln_apellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        cln_id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        cln_telefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
    }

    private void obtenerPacientes() {
        pacientes.clear();
        pacientes.addAll(controler.getPacientes());
    }

    private void listSelection(){
        tbl_pacientes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            pacientetbl = newValue;
            mostrarPaciente(pacientetbl);
        });
    }

    private void mostrarPaciente(Paciente pacientetbl) {
        if(pacientetbl != null){
            txt_nombre.setText(pacientetbl.getNombre());
            txt_apellido.setText(pacientetbl.getApellido());
            txt_id.setText(pacientetbl.getId());
            txt_telefono.setText(pacientetbl.getTelefono());
        }
    }

    private void initVoid(){
        System.out.println("initVoid");
        tbl_pacientes.setItems(null);
        initDataBinding();
        obtenerPacientes();
        tbl_pacientes.refresh();
        tbl_pacientes.setItems(pacientes);
        listSelection();
    }

    public void initialize(){
        controler = new PacientesControler();
    }

    public void setApp(App app, Administrador admin) {
        this.app = app;
        this.administrador = admin;
        initVoid();
    }

}
