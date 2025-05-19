package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;
import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Persona;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class IniciarSesionControler {

    App app;

    public Persona buscarPersona(String id) {
        for(Persona persona : app.hospital.getAdministradores()){
            if(persona.getId().equals(id)){
                return persona;
            }
        }
        for(Persona persona : app.hospital.getMedicos()){
            if(persona.getId().equals(id)){
                return persona;
            }
        }
        for(Persona persona : app.hospital.getPacientes()){
            if(persona.getId().equals(id)){
                return persona;
            }
        }
        return null;
    }
}
