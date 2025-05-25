package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Medico;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MedicosControler {

    Hospital hospital = App.hospital;

    public Collection<Medico> getMedicos(){
        return hospital.getMedicos();
    }

    public boolean agregarMedico(Medico m){
        return hospital.crearMedico(m);
    }

    public Medico buscarMedico(String id){
        return hospital.buscarMedico(id);
    }

    public boolean actualizarMedico(String nombre, String apellido, String id, String telefono){
        if (nombre.isBlank()){
            nombre = hospital.buscarMedico(id).getNombre();
        }
        if (apellido.isBlank()){
            apellido = hospital.buscarMedico(id).getApellido();
        }
        if (telefono.isBlank()){
            telefono = hospital.buscarMedico(id).getTelefono();
        }
        Medico medico = new Medico(nombre, apellido, id, telefono, hospital.buscarMedico(id).getHorarioinicio(), hospital.buscarMedico(id).getHorariofin());
        return hospital.modificarMedico(medico);
    }

    public boolean eliminarMedico(Administrador a, Medico m){
        return hospital.eliminarMedico(a.getId() ,m.getId());
    }

    public void setHorario(String medico, String horai, String horaf){
        hospital.buscarMedico(medico).setHorarioinicio(horai);
        hospital.buscarMedico(medico).setHorariofin(horaf);
    }
}
