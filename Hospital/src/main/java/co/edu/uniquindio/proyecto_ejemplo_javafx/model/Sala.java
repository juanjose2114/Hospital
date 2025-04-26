package co.edu.uniquindio.proyecto_ejemplo_javafx.model;

import java.util.ArrayList;





public class Sala {

    private String idsala;
    private boolean disponibilidad;
    private ArrayList<Persona> ocupantes;

    public Sala(String idsala) {
        this.idsala = idsala;
        this.disponibilidad = true;
        ocupantes = new ArrayList<>();
    }

    public String getIdsala(){
        return idsala;
    }
    public void setIdsala(String idsala){
        this.idsala = idsala;
    }
    public boolean getDisponibilidad(){
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad){
        this.disponibilidad = disponibilidad;
    }


}
