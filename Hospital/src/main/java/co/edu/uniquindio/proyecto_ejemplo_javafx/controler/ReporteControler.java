package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Cita;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Sala;

import java.util.ArrayList;
import java.util.List;

public class ReporteControler {

    Hospital hospital = App.hospital;

    public String getCitasT() {
        ArrayList<Cita> citas = new ArrayList<>();
        for (Cita cita : hospital.getCitas()) {
            if (cita.getEstado()) {
                citas.add(cita);
            }
        }
        return citas.size() + "";
    }

    public String getCitasF() {
        ArrayList<Cita> citas = new ArrayList<>();
        for (Cita cita : hospital.getCitas()) {
            if (!cita.getEstado()) {
                citas.add(cita);
            }
        }
        return citas.size() + "";
    }

    public String getSalasOcupadas() {
        ArrayList<Sala> salas = new ArrayList<>();
        for (Sala sala : List.of(hospital.getSalas())) {
            assert sala != null;
            if (sala.getDisponibilidad()) {
                salas.add(sala);
            }
        }
        return salas.size() + "";
    }

    public String getSalasDesocupadas() {
        ArrayList<Sala> salas = new ArrayList<>();
        for (Sala sala : List.of(hospital.getSalas())) {
            assert sala != null;
            if (!sala.getDisponibilidad()) {
                salas.add(sala);
            }
        }
        return salas.size() + "";
    }

    public String getNMedicos() {
        return hospital.getMedicos().size() + "";
    }

    public String getNAdministradores() {
        return hospital.getAdministradores().size() + "";
    }

    public String getNPacientes() {
        return hospital.getPacientes().size() + "";
    }


}
