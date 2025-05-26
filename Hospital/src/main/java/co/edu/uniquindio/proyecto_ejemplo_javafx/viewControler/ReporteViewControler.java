package co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.ReporteControler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ReporteViewControler {

    App app;
    Administrador administrador;
    ReporteControler controler;


//--------------------------------------------------------------------------

    @FXML
    public Button btn_volver;

    @FXML
    public TextField txt_citasT;

    @FXML
    public TextField txt_citasF;

    @FXML
    public TextField txt_salasocupadas;

    @FXML
    public TextField txt_salasdesocupadas;

    @FXML
    public TextField txt_nmedicos;

    @FXML
    public TextField txt_nadministradores;

    @FXML
    public TextField txt_npacientes;

//--------------------------------------------------------------------------

    @FXML
    public void volver() {
        app.openViewMenuAdministrador(administrador.getId());
    }

    private void cargarDatos() {
        txt_citasT.setText(controler.getCitasT());
        txt_citasF.setText(controler.getCitasF());
        txt_salasocupadas.setText(controler.getSalasOcupadas());
        txt_salasdesocupadas.setText(controler.getSalasDesocupadas());
        txt_nmedicos.setText(controler.getNMedicos());
        txt_nadministradores.setText(controler.getNAdministradores());
        txt_npacientes.setText(controler.getNPacientes());
    }


    public void initialize() {
        controler = new ReporteControler();
    }

    public void setApp(App app, Administrador administrador) {
        this.app = app;
        this.administrador = administrador;
        cargarDatos();
    }
}
