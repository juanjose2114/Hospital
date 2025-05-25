package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Paciente;

import java.util.Collection;

public class PacientesControler {

    Hospital hospital = App.hospital;


    public Collection<Paciente> getPacientes() {
        return hospital.getPacientes();
    }

    public void agregarPaciente(String idAdmin, String n, String a, String id, String t) {
        Paciente paciente = new Paciente(n, a, id, t);
        hospital.crearPaciente(idAdmin, paciente);
    }

    public void eliminarPaciente(String idAdmin, String idPaciente) {
        hospital.eliminarPaciente(idAdmin, idPaciente);
    }

    public void setNombre(String id, String nombre){
        hospital.buscarPaciente(id).setNombre(nombre);
    }

    public void setApellido(String id, String apellido){
        hospital.buscarPaciente(id).setApellido(apellido);
    }

    public void setTelefono(String id, String telefono){
        hospital.buscarPaciente(id).setTelefono(telefono);
    }
}
