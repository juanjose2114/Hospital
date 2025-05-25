package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Cita;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class MenuPacienteControler {

    Hospital hospital = App.hospital;

    public Collection<Cita> getCitas(String id){
        return hospital.getCitasPaciente(id);
    }

    public Collection<String> getHistoria(String id){
        return hospital.buscarPaciente(id).getHistorialClinico();
    }

    public Collection<String> getTratamiento(String id){
        return hospital.buscarPaciente(id).getTratamientos();
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

    public void agregarCita(String dia, String mes, String year, String id, String idPaciente){
        int idia = Integer.parseInt(dia);
        int imes = Integer.parseInt(mes);
        int iyear = Integer.parseInt(year);
        LocalDate fecha = LocalDate.of(iyear, imes, idia);
        Cita c = new Cita(fecha, id, idPaciente);
        hospital.agregarCita(c);
    }


    public void eliminarCita(String id) {
        hospital.eliminarCita(id);
    }
}
