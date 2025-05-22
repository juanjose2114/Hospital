package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.*;

import java.util.ArrayList;

import static co.edu.uniquindio.proyecto_ejemplo_javafx.App.hospital;

public class VerOcupantesControler {

    Hospital hospital = App.hospital;

    public String getInstance(Persona persona){
        if (persona instanceof Medico){
            return "Medico";
        }
        if (persona instanceof Paciente){
            return "Paciente";
        }
        if (persona instanceof Administrador){
            return "Administrador";
        }
        return "Persona";
    }

    public ArrayList<Persona> getPersonas(String idSala){
        return new ArrayList<>(hospital.buscarSala(idSala).getOcupantes());
    }

    public void actualizarPersona(String id, String nombre, String apellido, String telefono, String idSala){
        for (Persona p : getPersonas(idSala)){
            if (p.getId().equals(id)){
                p.setNombre(nombre);
                p.setApellido(apellido);
                p.setTelefono(telefono);
            }
        }
    }

    public void agregarPersona(String idPersona, String idSala, String idAdmin){
        System.out.println("2");
        Persona persona = hospital.buscarPaciente(idAdmin, idPersona);
        if (persona != null){
            hospital.buscarSala(idSala).agregarOcupante(persona);
        } else {
            persona = hospital.buscarMedico(idPersona);
            if (persona != null){
                hospital.buscarSala(idSala).agregarOcupante(persona);
            } else {
                persona = hospital.buscarAdministrador(idPersona);
                if (persona != null){
                    hospital.buscarSala(idSala).agregarOcupante(persona);
                }
            }
        }
    }

    public void sacarPersona(String idPersona, String idSala){
        for (Persona p : getPersonas(idPersona)){
            if (p.getId().equals(idPersona)){
                hospital.buscarSala(idSala).eliminarOcupante(idPersona);
                break;
            }
        }
    }
}
