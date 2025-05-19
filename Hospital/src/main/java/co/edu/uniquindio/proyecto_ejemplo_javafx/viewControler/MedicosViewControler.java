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

public class MedicosViewControler {

    MedicosControler controler;
    Medico medicotbl;
    Administrador administrador;
    Hospital hospital;
    App app;
    ObservableList<Medico> medicos = FXCollections.observableArrayList();

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

    @FXML
    public Button btn_revizarHorarioMedico;



    @FXML
    public void agregarMedico() {}

    @FXML
    public void actualizarMedico() {}


    private void limpiarSeleccion() {
        tbl_medicos.getSelectionModel().clearSelection();
    }


    public void mostrarMedico(Medico medicotbl) {
        if (medicotbl != null) {
            txt_id.setText(medicotbl.getId());
            txt_nombre.setText(medicotbl.getNombre());
            txt_apellido.setText(medicotbl.getApellido());
            txt_telefono.setText(medicotbl.getTelefono());
        }
    }

    private void initDataBinding(){
        // cln_Id.setCellFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        cln_Id.setCellFactory(cellData -> new SimpleStringProperty(cellData.cellValueFactoryProperty().getId()));
        cln_Telefono.setCellFactory(cellData -> new SimpleStringProperty(cellData.cellValueFactoryProperty().getTelefono()));
        cln_Apellido.setCellFactory(cellData -> new SimpleStringProperty(cellData.cellValueFactoryProperty().getApellido()));
        cln_Nombre.setCellFactory(cellData -> new SimpleStringProperty(cellData.cellValueFactoryProperty().getNombre()));
    }

    private void obtenerMedicos() {
        medicos.addAll(controler.getMedicos());
    }

    private void listSelection(){
        tbl_medicos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            medicotbl = newValue;
            mostrarMedico(medicotbl);
        });
    }

    @FXML
    public void initialize() {
        initDataBinding();
        obtenerMedicos();
        tbl_medicos.refresh();
        tbl_medicos.setItems(medicos);
        listSelection();

    }

    public void setApp(App app, Administrador admin) {
        this.app = app;
        this.hospital = hospital;
        this.administrador = admin;
    }
}
