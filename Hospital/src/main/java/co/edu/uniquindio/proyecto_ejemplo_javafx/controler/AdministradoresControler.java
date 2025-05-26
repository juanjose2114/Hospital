package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;

import java.util.Collection;

public class AdministradoresControler {

    Hospital hospital = App.hospital;

    public Collection<Administrador> getAdministradores() {
        return hospital.getAdministradores();
    }

    public void agregarAdministrador(String idAdmin, String n, String a, String id, String t){
        Administrador admin = new Administrador(n,a,id,t);
        hospital.crearAdministrador(idAdmin,admin);
        System.out.println("agregando");
    }

    public void eliminarAdministrador(String idAdmin){
        hospital.eliminarAdministrador(idAdmin);
    }

    public void actualizarMedico(String nombre, String apellido, String id, String telefono){
        System.out.println("actualizando");
        if (nombre.isBlank()){
            nombre = hospital.buscarMedico(id).getNombre();
        }
        if (apellido.isBlank()){
            apellido = hospital.buscarMedico(id).getApellido();
        }
        if (telefono.isBlank()){
            telefono = hospital.buscarMedico(id).getTelefono();
        }
        Administrador admin = new Administrador(nombre, apellido, id, telefono);
        hospital.modificarAdministrador(admin);
    }
}
