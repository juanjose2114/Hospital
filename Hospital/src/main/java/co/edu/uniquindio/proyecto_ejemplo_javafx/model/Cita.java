package co.edu.uniquindio.proyecto_ejemplo_javafx.model;

import java.time.LocalDate;

/**
 * Clase que representa una Cita médica en el sistema hospitalario.
 * Gestiona la fecha, identificación y estado de completitud de la cita.
 */
public class Cita {

    /**
     * Fecha programada para la cita (usando LocalDate para manejo moderno de fechas)
     */
    private LocalDate fecha;

    /**
     * Identificador único de la cita
     */
    private String id;


    private String idPaciente;

    /**
     *  Estado de la cita:
     *  - false: cita completada
     *  - true: cita pendiente
     */
    private boolean estado;

    /**
     * Constructor para crear una nueva cita médica.
     * @param fecha Fecha programada para la cita (ej: 2023-12-15)
     * @param id Identificador único de la cita (ej: "CITA-2023-001")
     */
    public Cita(LocalDate fecha, String id, String idPaciente) {
        this.fecha = fecha;
        this.id = id;
        this.idPaciente = idPaciente;
        this.estado = true; // Por defecto, la cita se crea como pendiente
    }

    // ==================== MÉTODOS DE ACCESO ====================

    /**
     * Obtiene la fecha programada de la cita.
     * @return Objeto LocalDate con la fecha de la cita.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    public String getFechaS(){
        return fecha.toString();
    }

    /**
     * Establece una nueva fecha para la cita.
     * @param fecha Nueva fecha a asignar (debe ser LocalDate).
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el estado actual de la cita.
     * @return true si la cita está completada, false si está pendiente.
     */
    public boolean getEstado() {
        return estado;
    }

    public String getEstadoS(){
        if(estado){return "Pendiente";}
        return "Inactivo";
    }

    /**
     * Cambia el estado de la cita (completada/pendiente).
     * @param estado Nuevo estado a asignar (true = completada, false = pendiente).
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el identificador único de la cita.
     * @return String con el ID de la cita.
     */
    public String getId() {
        return id;
    }

    public String getPaciente() {
        return idPaciente;
    }

}