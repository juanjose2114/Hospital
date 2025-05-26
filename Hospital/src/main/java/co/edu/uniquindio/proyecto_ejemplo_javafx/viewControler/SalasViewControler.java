package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.SalasControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Sala;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import static java.lang.String.valueOf;

public class SalasViewControler {

    App app;
    Administrador administrador;
    Hospital hospital = App.hospital;
    SalasControler controler;
    Sala salatbl;

    ObservableList<Sala> salas = FXCollections.observableArrayList();

//----------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button btn_volver;

    @FXML
    public TextField txt_idsala;

    @FXML
    public TextField txt_estado;

    @FXML
    public TextField txt_idcita;

    @FXML
    public Button btn_agregar;

    @FXML
    public Button btn_actualizar;

    @FXML
    public TableView<Sala> tbl_salas;

    @FXML
    public TableColumn<Sala, String> cln_idsala;

    @FXML
    public TableColumn<Sala, String> cln_estado;

    @FXML
    public TableColumn<Sala, String> cln_nocupantes;

    @FXML
    public Button btn_limpiar;

    @FXML
    public Button btn_vaciarsala;

    @FXML
    public Button btn_ocupantes;

//----------------------------------------------------------------------------------------------------------------------

    @FXML
    public void volver(){
        app.openViewMenuAdministrador(administrador.getId());
    }

    @FXML
    public void agregarCita(){
        if (txt_estado.getText().equals("Disponible")) {
            String idcita = txt_idcita.getText();
            String idsala = txt_idsala.getText();
            if (!idcita.isBlank()) {
                controler.asignarCita(idcita, idsala);
            }
        }
        initVoid();
    }

    @FXML
    public void eliminarctia(){
        controler.eliminarCita(txt_idsala.getText());
        initVoid();
    }

    @FXML
    public void vaciarsala(){
        System.out.println("entrando metodo");
        controler.vaciarSala(txt_idsala.getText());
        initVoid();
    }

    @FXML
    public void verOcupantes(){
        if (hospital.buscarSala(txt_idsala.getText()) != null){
            app.openViewVerOcupanetes(administrador.getId(), txt_idsala.getText());
        }
    }

    @FXML
    public void limpiarSeleccion(){
        tbl_salas.getSelectionModel().clearSelection();
        limpiarCampos();
        tbl_salas.refresh();
    }



    private void limpiarCampos(){
        txt_idsala.clear();
        txt_idcita.clear();
        txt_estado.clear();
    }

    private void mostrarSala(Sala salatbl){
        if (salatbl != null) {
            txt_idsala.setText(salatbl.getIdsala());
            txt_estado.setText(salatbl.getDisponibilidadS());
            if (salatbl.getCita() != null) {
                txt_idcita.setText(salatbl.getCita().getId());
            } else
                txt_idcita.clear();
        }
    }

    private void initDataBinding(){
        cln_idsala.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdsala()));
        cln_estado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDisponibilidadS()));
        cln_nocupantes.setCellValueFactory(cellData -> new SimpleStringProperty(valueOf(cellData.getValue().getOcupantes().size())));
    }

    private void obtenerSalas(){
        salas.clear();
        salas.addAll(controler.getSalas());
    }

    private void listSelection(){
        tbl_salas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            salatbl = newValue;
            mostrarSala(salatbl);
        });
    }

    private void initVoid(){
        tbl_salas.setItems(null);
        initDataBinding();
        obtenerSalas();
        tbl_salas.refresh();
        tbl_salas.setItems(salas);
        listSelection();
    }

    public void initialize(){
        controler = new SalasControler();
    }

    public void setApp(App app, Administrador admin){
        this.app = app;
        this.administrador = admin;
        initVoid();
    }

}
