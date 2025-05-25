package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Cita;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Paciente;

public class RecordatorioControler {

    Hospital hospital = App.hospital;

    public String enviarRecordatorio(){
        Paciente p;
        int contador = 0;
        for (Cita c : hospital.getCitas()){
            p = hospital.buscarPaciente(c.getPaciente());
            System.out.println("enviando recordatorio a " + p.getNombre() + " al telefono " + p.getTelefono() + "por la cita " + c.getId() + " para el dia " + c.getFecha() + "\n|--------------------------------------------");
            contador++;
        }
        return contador + "";
    }

}
