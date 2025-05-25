package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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

    /**
     * Obtiene los ocupantes de una sala
     * @param idSala Identificador de la sala (no debe ser null)
     * @return Colección de personas (nunca null, puede estar vacía)
     */
    public Collection<Persona> getPersonas(String idSala){
        Sala sala = hospital.buscarSala(idSala);
        if (sala == null) {
            System.err.println("Advertencia: La sala es nula en obtenerPersona()");
            return Collections.emptyList();
        }
        try {
            return sala.getOcupantes();
        } catch (NullPointerException e) {
            System.err.println("Error al obtener ID de sala: " + e.getMessage());
            return Collections.emptyList();
        }
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
        Persona persona = hospital.buscarPaciente(idPersona);
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
        for (Persona p : getPersonas(idSala)){
            if (p.getId().equals(idPersona)){
                hospital.buscarSala(idSala).eliminarOcupante(idPersona);
                break;
            }
        }
    }
}
