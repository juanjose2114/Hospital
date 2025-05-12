package co.edu.uniquindio.proyecto_ejemplo_javafx;

import co.edu.uniquindio.proyecto_ejemplo_javafx.controler.PrimaryController;
import co.edu.uniquindio.proyecto_ejemplo_javafx.viewControler.MenuInicioViewController;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;
    public static Hospital hospital = new Hospital("san juan pepe fernando muñoz", 15);

    @Override
    public void start(Stage stage) throws IOException {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Menu de inicio Hospital");
        openViewMenuInicio();
    }

    public void openViewMenuInicio(){
        inicializarData();
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void openHospitalMenuInicio(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("hospital.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuInicioViewController menuInicioViewController = loader.getController();
            menuInicioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void inicializarData(){
        Administrador admin1 = new Administrador("Juanjose", "Arias", "1092", "301364");
        hospital.crearAdministrador(admin1);
    }
}