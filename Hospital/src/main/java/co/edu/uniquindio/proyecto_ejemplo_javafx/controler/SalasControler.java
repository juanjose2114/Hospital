package co.edu.uniquindio.proyecto_ejemplo_javafx.controler;

import co.edu.uniquindio.proyecto_ejemplo_javafx.App;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Cita;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Hospital;
import co.edu.uniquindio.proyecto_ejemplo_javafx.model.Sala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SalasControler {

    Hospital hospital = App.hospital;

    public Collection<Sala>  getSalas(){
        Sala[] ArraySalas = hospital.getSalas();
        return Arrays.asList(ArraySalas);
    }

    public void asignarCita(String cita, String sala){
        hospital.ocuparSala(sala, null, cita);
    }

    public void eliminarCita(String idsala){
        Sala sala = hospital.buscarSala(idsala);
        if(sala != null){
            sala.eliminarCita();
        }
    }

    public void vaciarSala(String idsala){
        hospital.vaciarSala(idsala);
    }
}
