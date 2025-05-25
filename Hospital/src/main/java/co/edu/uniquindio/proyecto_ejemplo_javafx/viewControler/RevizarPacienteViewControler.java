package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.RevizarPacienteControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Cita;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Medico;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static java.lang.String.valueOf;

public class RevizarPacienteViewControler {

    App app;
    Medico medico;
    Paciente paciente;
    RevizarPacienteControler controler;
    Hospital hospital = App.hospital;

    Cita citatbl;
    String historia;
    String tratamiento;

    ObservableList<Cita> citas = FXCollections.observableArrayList();
    ObservableList<String> tratamientos = FXCollections.observableArrayList();
    ObservableList<String> historias = FXCollections.observableArrayList();


//------------------------------------------------------------------

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
    public Button btn_actualizarDatos;

    @FXML
    public TableView<Cita> tbl_cita;

    @FXML
    public TableColumn<Cita, String> cln_idcita;

    @FXML
    public TableColumn<Cita, String> cln_fecha;

    @FXML
    public TableColumn<Cita, String> cln_estado;

    @FXML
    public TextField txt_idCita;

    @FXML
    public TextField txt_diaCita;

    @FXML
    public TextField txt_mesCita;

    @FXML
    public TextField txt_yearCita;

    @FXML
    public Button btn_agregarCita;

    @FXML
    public Button btn_cambiarEstado;

    @FXML
    public TableView<String> tbl_historial;

    @FXML
    public TableColumn<String, String> cln_historial;

    @FXML
    public TextArea txa_historial;

    @FXML
    public Button btn_actualizarHistorial;

    @FXML
    public TableView<String> tbl_tratamiento;

    @FXML
    public TableColumn<String, String> cln_tratamiento;

    @FXML
    public TextArea txa_tratamiento;

    @FXML
    public Button btn_actualizarTratamiento;

//------------------------------------------------------------------


    @FXML
    public void volver() {
        app.openViewMenuMedico(medico.getId());
    }

    @FXML
    public void agregarCita(){
        if (!txt_id.getText().isBlank()) {
            controler.agregarCita(txt_diaCita.getText(), txt_mesCita.getText(), txt_yearCita.getText(), txt_idCita.getText(), paciente.getId());
        }
        initVoid();
    }

    @FXML
    public void cambiarEstado(){
        if (!txt_id.getText().isBlank()) {
            controler.setEstado(txt_idCita.getText());
        }
        initVoid();
    }

    @FXML
    public void agregarHistorial(){}

    @FXML
    public void eliminarHistorial(){}

    @FXML
    public void agregarTratamiento(){}

    @FXML
    public void eliminarTratamiento(){}

    @FXML
    public void actualizarDatos(){}



    @FXML
    public void limpiarSeleccion(){
        txt_diaCita.clear();
        txt_mesCita.clear();
        txt_yearCita.clear();
        txt_idCita.clear();
    }

    public void mostrarPaciente(){
        txt_nombre.setText(paciente.getNombre());
        txt_apellido.setText(paciente.getApellido());
        txt_id.setText(paciente.getId());
        txt_telefono.setText(paciente.getTelefono());
        limpiarSeleccion();
    }

    public void initDataBinding(){
        cln_idcita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        cln_fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaS()));
        cln_estado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstadoS()));
        cln_historial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        cln_tratamiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
    }

    public void obtenerCitas(){
        citas.clear();
        historias.clear();
        tratamientos.clear();

        citas.addAll(controler.getCitas(paciente.getId()));
        historias.addAll(controler.getHistoria(paciente.getId()));
        tratamientos.addAll(controler.getTratamiento(paciente.getId()));
    }

    public void listSelecionC(){
        tbl_cita.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            citatbl = newValue;
            mostrarCitas(citatbl);
        });
    }

    public void mostrarCitas(Cita c){
        if(c != null){
            txt_diaCita.setText(valueOf(c.getFecha().getDayOfYear()));
            txt_mesCita.setText(valueOf(c.getFecha().getMonthValue()));
            txt_yearCita.setText(valueOf(c.getFecha().getYear()));
            txt_idCita.setText(c.getId());
        }
    }

    public void listSelecionH(){
        tbl_historial.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            historia = newValue;
            mostrarHistoria(historia);
        });
    }

    public void mostrarHistoria(String h){
        txa_historial.setText(h);
    }

    public void listSelecionT(){
        tbl_tratamiento.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            tratamiento = newValue;
            mostrarTratamiento(tratamiento);
        });
    }

    public void mostrarTratamiento(String t){
        txa_tratamiento.setText(t);
    }

    public void initVoid(){
        System.out.println("initVoid");
        tbl_cita.setItems(null);
        tbl_historial.setItems(null);
        tbl_tratamiento.setItems(null);

        initDataBinding();
        obtenerCitas();

        tbl_cita.refresh();
        tbl_historial.refresh();
        tbl_tratamiento.refresh();

        tbl_cita.setItems(citas);
        tbl_tratamiento.setItems(tratamientos);
        tbl_historial.setItems(historias);

        listSelecionC();
        listSelecionH();
        listSelecionT();

        mostrarPaciente();
    }

    @FXML
    public void initialize() {
        controler = new RevizarPacienteControler();
    }

    public void setApp(App app, Medico medico, Paciente paciente) {
        this.app = app;
        this.medico = medico;
        this.paciente = paciente;
        initVoid();
    }
}
