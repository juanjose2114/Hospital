package co.edu.uniquindio.proyecto_ejemplo_javafx;

import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.MenuInicioController;
import co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler.MenuInicioViewController;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;

// Importes de JavaFX para JDK 23
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App extends Application {

    private Stage primaryStage;
    public static Hospital hospital = new Hospital("san juan pepe fernando muñoz", 15);



    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Menu de inicio Hospital");
        openViewMenuInicio();
    }
    public void openViewMenuInicio() {
        try {
            // Debug: Imprime la ruta absoluta donde busca
            String fxmlPath = "MenuInicio.fxml";
            System.out.println("Buscando FXML en: " +
                    new File("src/main/resources" + fxmlPath).getAbsolutePath());

            // Carga el FXML usando ClassLoader
            FXMLLoader loader = new FXMLLoader();
            URL resourceUrl = getClass().getResource(fxmlPath);
            if (resourceUrl == null) {
                throw new RuntimeException("Archivo FXML no encontrado en: " + fxmlPath);
            }
            loader.setLocation(resourceUrl);

            Parent root = loader.load();
            MenuInicioController controller = loader.getController();
            controller.setApp(this);

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

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showFatalError(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Fatal");
        alert.setHeaderText("Error al iniciar la aplicación");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }


    public static void main(String[] args) {
        Application.launch(args);
        //launch();
    }



    public void inicializarData(){
        Administrador admin1 = new Administrador("nombre", "apellidio", "1", "1");
        hospital.crearAdministrador(admin1);
    }
}