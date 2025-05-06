package co.edu.uniquindio.proyecto_ejemplo_javafx.model;
import java.util.ArrayList;

/**
 * Clase que representa una sala física con capacidad para ocupantes.
 * Permite gestionar la disponibilidad y administrar los ocupantes de la sala.
 */
public class Sala {

    /**
     * Identificador único de la sala (String).
     */
    private String idsala;

    /**
     * Estado de disponibilidad de la sala:
     * - true: Sala disponible
     * - false: Sala ocupada/no disponible
     */
    private boolean disponibilidad;

    /**
     * Lista de personas que ocupan la sala.
     */
    private ArrayList<Persona> ocupantes;

    /**
     * Cita asignada a la sala. Puede ser null. Paralelo a disponibilidad.
     */
    private Cita cita;

    // ==================== CONSTRUCTOR ====================

    /**
     * Crea una nueva instancia de Sala con el identificador especificado.
     * @param idsala Identificador único para la nueva sala.
     * @throws IllegalArgumentException Si el idsala es nulo o vacío
     */
    public Sala(String idsala) {
        if(idsala == null || idsala.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la sala no puede ser nulo o vacío");
        }
        this.idsala = idsala;
        this.cita = null;
        this.disponibilidad = true;
        this.ocupantes = new ArrayList<>();
    }

    // ==================== MÉTODOS DE ACCESO (GETTERS/SETTERS) ====================

    /**
     * Obtiene el identificador de la sala.
     * @return ID actual de la sala.
     */
    public String getIdsala() {
        return idsala;
    }

    /**
     * Obtiene la cita asignada a la sala.
     * @return cita actual de la sala.
     */
    public Cita getCita() {
        return cita;
    }

    /**
     * Establece una nueva cita para la sala.
     * @param cita Nueva cita a asignar.
     */
    public void setCita(Cita cita) {
        this.cita = cita;
        this.disponibilidad = (cita == null);
    }

    /**
     * Verifica el estado de disponibilidad de la sala.
     * @return true si está disponible, false si está ocupada.
     */
    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Cambia el estado de disponibilidad de la sala.
     * @param disponibilidad Nuevo estado a asignar (true/false).
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
        if(disponibilidad) {
            this.cita = null;
        }
    }

    // ==================== MÉTODOS PARA GESTIÓN DE OCUPANTES ====================

    /**
     * Obtiene la lista completa de ocupantes de la sala.
     * @return ArrayList de Personas que ocupan la sala.
     */
    public ArrayList<Persona> getOcupantes() {
        return new ArrayList<>(ocupantes);
    }

    /**
     * Reemplaza completamente el conjunto de ocupantes de la sala.
     * @param ocupantes Nueva lista de ocupantes a asignar.
     */
    public void setOcupantes(ArrayList<Persona> ocupantes) {
        this.ocupantes = new ArrayList<>(ocupantes);
    }

    /**
     * Agrega un nuevo ocupante a la sala.
     * @param ocupante Persona a agregar como ocupante.
     * @return true si se agregó correctamente, false si ya existe.
     * @throws IllegalArgumentException Si el ocupante es nulo.
     */
    public boolean agregarOcupante(Persona ocupante) {
        if(ocupante == null) {
            throw new IllegalArgumentException("El ocupante no puede ser nulo");
        }

        if(buscarOcupante(ocupante.getId()) != null) {
            return false;
        }

        return ocupantes.add(ocupante);
    }

    /**
     * Busca un ocupante en la sala por su identificador.
     * @param id Identificador de la persona a buscar.
     * @return Persona encontrada o null si no existe.
     */
    public Persona buscarOcupante(String id) {
        for(Persona ocupante : ocupantes) {
            if(ocupante != null && ocupante.getId().equals(id)) {
                return ocupante;
            }
        }
        return null;
    }

    /**
     * Actualiza los datos de un ocupante existente en la sala.
     * @param ocupante Persona con los datos actualizados.
     * @return true si se modificó correctamente, false si no se encontró al ocupante.
     * @throws IllegalArgumentException Si el ocupante es nulo.
     */
    public boolean modificarOcupante(Persona ocupante) {
        if(ocupante == null) {
            throw new IllegalArgumentException("El ocupante no puede ser nulo");
        }

        for(int i = 0; i < ocupantes.size(); i++) {
            if(ocupantes.get(i).getId().equals(ocupante.getId())) {
                ocupantes.set(i, ocupante);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un ocupante de la sala por su identificador.
     * @param id Identificador de la persona a eliminar.
     * @return true si se eliminó correctamente, false si no se encontró al ocupante.
     */
    public boolean eliminarOcupante(String id) {
        return ocupantes.removeIf(p -> p != null && p.getId().equals(id));
    }

    // ==================== MÉTODOS ADICIONALES ====================

    /**
     * Verifica si la sala está vacía (sin ocupantes).
     * @return true si no hay ocupantes, false si hay al menos uno.
     */
    public boolean estaVacia() {
        return ocupantes.isEmpty();
    }

    /**
     * Obtiene el número actual de ocupantes en la sala.
     * @return Cantidad de ocupantes.
     */
    public int getN_personas() {
        return ocupantes.size();
    }

    @Override
    public String toString() {
        return String.format("Sala [ID: %s, Disponible: %s, Ocupantes: %d, Cita: %s]",
                idsala,
                disponibilidad ? "Sí" : "No",
                ocupantes.size(),
                cita != null ? cita.getId() : "Ninguna");
    }
}