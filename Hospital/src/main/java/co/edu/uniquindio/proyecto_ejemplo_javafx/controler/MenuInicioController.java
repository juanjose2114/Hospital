package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Administrador;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;

public class MenuInicioController {
    Hospital hospital;

    public MenuInicioController(Hospital hospital) {
        this.hospital = hospital;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean crearAdministrador(Administrador administrador) {
        return hospital.crearAdministrador(administrador);
    }

    public boolean eliminarAdministrador(String id) {
        return hospital.eliminarAdministrador(id);
    }
}

