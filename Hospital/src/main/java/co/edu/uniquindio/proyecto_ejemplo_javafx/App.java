package co.edu.uniquindio.proyecto_ejemplo_javafx;

import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Sala;
import co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class App extends Application {

    private Stage primaryStage;
    public static Hospital hospital = new Hospital("san juan pepe fernando muñoz", 15);

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Menu de inicio Hospital");
        inicializarData();
        openViewMenuInicio();
    }

    public void openView(String fxmlPath, String usuario, String id) {
        try{
            System.out.println("creando Loader");
            FXMLLoader loader = new FXMLLoader();
            System.out.println("configurando Loader con: " + fxmlPath);
            loader.setLocation(getClass().getResource(fxmlPath));
            System.out.println("parent root\n-----" + loader.getLocation());
            Parent root = loader.load();
            System.out.println("llamado el setApp\n-----" + fxmlPath);
            switch (fxmlPath){
                case "MenuInicio.fxml":
                    MenuInicioViewController controller1 = loader.getController();
                    controller1.setApp(this);
                    break;
                case "IniciarSesion.fxml":
                    IniciarSesionViewControler controller2 = loader.getController();
                    controller2.setApp(this);
                    break;
                case "MenuAdministrador.fxml":
                    MenuAdministradorViewControler controller3 = loader.getController();
                    controller3.setApp(this, hospital.buscarAdministrador(usuario));
                    break;
                case "MenuMedico.fxml":
                    MenuMedicoViewControler controller4 = loader.getController();
                    controller4.setApp(this, hospital.buscarMedico(usuario));
                    break;
                case "MenuPaciente.fxml":
                    MenuPacienteViewControler controller5 = loader.getController();
                    controller5.setApp(this, hospital.buscarPaciente(usuario));
                    break;
                case "Medicos.fxml":
                    MedicosViewControler controller6 = loader.getController();
                    controller6.setApp(this, hospital.buscarAdministrador(usuario));
                    break;
                case "Error.fxml":
                    ErrorViewControler controller7 = loader.getController();
                    controller7.setApp(this, usuario);
                    break;
                case "Salas.fxml":
                    SalasViewControler controller8 = loader.getController();
                    controller8.setApp(this, hospital.buscarAdministrador(usuario));
                    break;
                case "VerOcupantes.fxml":
                    VerOcupantesViewControler controler9 = loader.getController();
                    controler9.setApp(this, hospital.buscarAdministrador(usuario), hospital.buscarSala(id));
                    break;
                case "RevizarPaciente.fxml":
                    RevizarPacienteViewControler controller10 = loader.getController();
                    controller10.setApp(this, hospital.buscarMedico(usuario), hospital.buscarPaciente(id));
                    break;
                case "Pacientes.fxml":
                    PacientesViewControler controller11 = loader.getController();
                    controller11.setApp(this, hospital.buscarAdministrador(usuario));
                    break;
                case "Administradores.fxml":
                    AdministradoresViewControler controller12 = loader.getController();
                    controller12.setApp(this, hospital.buscarAdministrador(usuario));
                    break;
                case "Reporte.fxml":
                    ReporteViewControler controller13 = loader.getController();
                    controller13.setApp(this, hospital.buscarAdministrador(usuario));
                    break;
                case "Recordatorio.fxml":
                    RecordatorioViewControler controller14 = loader.getController();
                    controller14.setApp(this, hospital.buscarAdministrador(usuario));
                    break;
            }
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error al cargar FXML:");
            e.printStackTrace();
            showErrorAlert("Error fatal", "No se pudo cargar la interfaz:" + e.getMessage());
            System.out.println(e.getMessage());
            //openViewError("No se pudo cargar la interfaz:" + e.getMessage());
        }
    }

    public void openViewMenuMedico(String usuario) {
        openView("MenuMedico.fxml", usuario, null);
    }

    public void openViewAdministradores(String usuario){
        openView("Administradores.fxml", usuario, null);
    }

    public void openViewError(String msg){
        openView("Error.fxml", msg, null);
    }

    public void openViewIniciarSesion() {
        openView("IniciarSesion.fxml", null, null);
    }

    public void openViewMedicos(String usuario){
        openView("Medicos.fxml", usuario, null);
    }

    public void openViewMenuAdministrador(String usuario) {
        openView("MenuAdministrador.fxml", usuario, null);
    }

    public void openViewMenuInicio() {
        openView("MenuInicio.fxml", "", null);
    }

    public void openViewMenuPaciente(String usuario){
        openView("MenuPaciente.fxml", usuario, null);
    }

    public void openViewPacientes(String usuario){
        openView("Pacientes.fxml", usuario, null);
    }

    public void openViewRecordatorio(String usuario) {
        openView("Recordatorio.fxml", usuario, null);
    }

    public void openViewReporte(String usuario){
        openView("Reporte.fxml", usuario, null);
    }

    public void openViewRevizarPaciente(String usuario, String id){
        openView("RevizarPaciente.fxml", usuario, id);
    }

    public void openViewSalas(String usuario) {
        openView("Salas.fxml", usuario, null);

    }

    public void openViewVerOcupanetes(String usuario, String idSala){
        openView("VerOcupantes.fxml", usuario, idSala);
    }



    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void inicializarData(){}
}