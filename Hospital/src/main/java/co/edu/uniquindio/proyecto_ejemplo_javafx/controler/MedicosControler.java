package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Medico;

import java.util.ArrayList;

public class MedicosControler {
    Hospital hospital;

    public ArrayList<Medico> getMedicos(){
        return hospital.getMedicos();
    }
}
