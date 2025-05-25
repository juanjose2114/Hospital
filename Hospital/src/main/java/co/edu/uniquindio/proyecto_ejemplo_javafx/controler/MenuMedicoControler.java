package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Paciente;

public class MenuMedicoControler {

    Hospital hospital = App.hospital;

    public Paciente buscarPaciente(String id) {
        Paciente paciente = hospital.buscarPaciente(id);
        if (paciente == null) {
            return null;
        }
        return paciente;
    }
}
