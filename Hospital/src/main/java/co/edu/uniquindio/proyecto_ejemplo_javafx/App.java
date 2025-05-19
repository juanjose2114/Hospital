package co.edu.uniquindio.proyecto_ejemplo_javafx;

import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
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

    public void openView(String fxmlPath, String usuario) {
        try{
            FXMLLoader loader = new FXMLLoader();
            URL resourceUrl = getClass().getResource(fxmlPath);
            if (resourceUrl == null) {
                throw new RuntimeException("Archivo FXML no encontrado en: " + fxmlPath);
            }
            loader.setLocation(resourceUrl);
            Parent root = loader.load();
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
                    //controller5.setApp();
                case "Medicos.fxml":
                    MedicosViewControler controller6 = loader.getController();
                    controller6.setApp(this, hospital.buscarAdministrador(usuario));

            }
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error al cargar FXML:");
            e.printStackTrace();
            showErrorAlert("Error fatal", "No se pudo cargar la interfaz: " + e.getMessage());
            Platform.exit();
        }
    }

    public void openViewMenuMedico(String usuario) {
        openView("MenuMedicos.fxml", usuario);
    }


    public void openViewAdministradores(String usuario){
        openView("Administradores.fxml", usuario);
    }

    public void openViewError(String usuario){
        openView("Error.fxml", usuario);
    }

    public void openViewHorario(String usuario){
        openView("Horario.fxml", usuario);
    }

    public void openViewIniciarSesion() {
        openView("IniciarSesion.fxml", null);
    }

    public void openViewMedicos(String usuario){
        openView("Medicos.fxml", usuario);
    }

    public void openViewMenuAdministrador(String usuario) {
        openView("MenuAdministrador.fxml", usuario);
    }

    public void openViewMenuInicio() {
        openView("MenuInicio.fxml", "");
    }

    public void openViewMenuPaciente(String usuario){
        openView("MenuPaciente.fxml", "");
    }

    public void openViewPacientes(String usuario){
        openView("Pacientes.fxml", usuario);
    }

    public void openViewRecordatorio(String usuario) {
        openView("Recordatorio.fxml", usuario);
    }

    public void openViewReporte(String usuario){
        openView("Reporte.fxml", usuario);
    }

    public void openViewRevizarPaciente(String usuario){
        openView("RevizarPaciente.fxml", usuario);
    }

    public void openViewSalas(String usuario) {
        openView("Salas.fxml", usuario);
    }

    public void openViewVerOcupanetes(String usuario){
        openView("VerOcupanetes.fxml", "");
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

    public void inicializarData(){
    }
}