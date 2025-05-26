package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.MenuPacienteControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import static java.lang.String.valueOf;

public class MenuPacienteViewControler {

    App app;
    Paciente paciente;
    MenuPacienteControler controler;
    Hospital hospital = App.hospital;

    Cita citatbl;

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
    public Button btn_actualizardatos;

    @FXML
    public TableView<Cita> tbl_cita;

    @FXML
    public TableColumn<Cita, String> cln_idcita;

    @FXML
    public TableColumn<Cita, String> cln_fecha;

    @FXML
    public TableColumn<Cita, String> cln_estado;

    @FXML
    public Button btn_agendarcita;

    @FXML
    public TextField txt_diaCita;

    @FXML
    public TextField txt_mesCita;

    @FXML
    public TextField txt_yearCita;

    @FXML
    public Button btn_eliminarcita;

    @FXML
    public TextField txt_idcita;

    @FXML
    public Button btn_limpiar;

    @FXML
    public TableView<String> tbl_historial;

    @FXML
    public TableColumn<String, String> cln_historial;

    @FXML
    public TableView<String> tbl_tratamiento;

    @FXML
    public TableColumn<String, String> cln_tratamiento;

//------------------------------------------------------------------

    @FXML
    public void volver() {
        app.openViewIniciarSesion();
    }

    @FXML
    public void actualizarDatos() {
        if (!txt_id.getText().isBlank()) {
            if (txt_nombre.getText().isEmpty()) {
                controler.setNombre(txt_id.getText(), txt_nombre.getText());
            }
            if (txt_apellido.getText().isEmpty()) {
                controler.setApellido(txt_apellido.getText(), txt_apellido.getText());
            }
            if (txt_telefono.getText().isEmpty()) {
                controler.setTelefono(txt_telefono.getText(), txt_telefono.getText());
            }
            this.paciente = hospital.buscarPaciente(txt_id.getText());
            mostrarPaciente();
        }
    }

    @FXML
    public void agregarCita() {
        if (!txt_diaCita.getText().isBlank() && !txt_mesCita.getText().isBlank() && !txt_yearCita.getText().isBlank() && !txt_id.getText().isBlank()) {
            controler.agregarCita(txt_diaCita.getText(), txt_mesCita.getText(), txt_mesCita.getText(), txt_idcita.getText(), paciente.getId());
        }
        initVoid();
    }

    @FXML
    public void eliminarCita() {
        if (!txt_idcita.getText().isBlank()) {
            controler.eliminarCita(txt_idcita.getText());
        }
        initVoid();
    }

    @FXML
    public void limpiarSeleccion() {
        txt_diaCita.clear();
        txt_mesCita.clear();
        txt_yearCita.clear();
        txt_idcita.clear();
    }



    private void mostrarPaciente(){
        txt_nombre.setText(paciente.getNombre());
        txt_apellido.setText(paciente.getApellido());
        txt_id.setText(paciente.getId());
        txt_telefono.setText(paciente.getTelefono());
        limpiarSeleccion();
    }

    private void initDataBinding(){
        cln_idcita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        cln_fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaS()));
        cln_estado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstadoS()));
        cln_historial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        cln_tratamiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
    }

    private void obtenerCitas(){
        citas.clear();
        historias.clear();
        tratamientos.clear();

        citas.addAll(controler.getCitas(paciente.getId()));
        historias.addAll(controler.getHistoria(paciente.getId()));
        tratamientos.addAll(controler.getTratamiento(paciente.getId()));
    }

    private void listSelecion(){
        tbl_cita.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            citatbl = newValue;
            mostrarCitas(citatbl);
        });
    }

    private void mostrarCitas(Cita citatbl){
        if(citatbl != null){
            txt_diaCita.setText(valueOf(citatbl.getFecha().getDayOfYear()));
            txt_mesCita.setText(valueOf(citatbl.getFecha().getMonthValue()));
            txt_yearCita.setText(valueOf(citatbl.getFecha().getYear()));
            txt_idcita.setText(citatbl.getId());
        }
    }

    private void initVoid(){
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

        listSelecion();

        mostrarPaciente();
    }

    public void initialize() {
        controler = new MenuPacienteControler();
    }

    public void setApp(App app, Paciente paciente) {
        this.app = app;
        this.paciente = paciente;
        initVoid();
    }
}
