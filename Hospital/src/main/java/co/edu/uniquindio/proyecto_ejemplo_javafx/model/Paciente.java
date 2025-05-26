package co.edu.uniquindio.proyecto_ejemplo_javafx.model;

import java.util.LinkedList;

/**
 * Clase que representa a un Paciente en un sistema médico.
 * Hereda de Administrador y gestiona su historial clínico y tratamientos.
 */
public class Paciente extends Persona {

    // Lista para almacenar el historial clínico del paciente
    private LinkedList<String> historialClinico;
    // Lista para almacenar los tratamientos del paciente
    private LinkedList<String> tratamientos;

    /**
     * Constructor para crear un nuevo Paciente.
     * @param nombre    Nombre del paciente.
     * @param apellido  Apellido del paciente.
     * @param id        Identificación única.
     * @param telefono  Número de teléfono.
     */
    public Paciente(String nombre, String apellido, String id, String telefono) {
        super(nombre, apellido, id, telefono);
        historialClinico = new LinkedList<>();  // Inicializa la lista de historial clínico
        tratamientos = new LinkedList<>();     // Inicializa la lista de tratamientos
    }

    // ==================== MÉTODOS PARA HISTORIAL CLÍNICO ====================

    /**
     * Obtiene la lista completa del historial clínico.
     * @return Lista con todos los registros clínicos.
     */
    public LinkedList<String> getHistorialClinico() {
        return historialClinico;
    }

    /**
     * Agrega un nuevo registro al historial clínico (si no existe).
     *
     * @param clinico Registro clínico a agregar.
     */
    public void agregarHistorialClinico(String clinico) {
        for (String s : historialClinico) {
            if (s.equals(clinico)) {
                return;  // Evita duplicados
            }
        }
        historialClinico.add(clinico);
    }

    /**
     * Busca un registro específico en el historial clínico.
     * @param clinico Registro a buscar.
     * @return El registro si existe, o null si no se encuentra.
     */
    public String revisarHistorialClinico(String clinico) {
        for (String s : historialClinico) {
            if (s.equals(clinico)) {
                return s;  // Retorna el registro encontrado
            }
        }
        return null;  // No encontrado
    }

    /**
     * Elimina un registro del historial clínico.
     *
     * @param clinico Registro a eliminar.
     */
    public void eliminarHistorialClinico(String clinico) {
        if (revisarHistorialClinico(clinico) != null) {
            historialClinico.remove(clinico);
        }
    }

    // ==================== MÉTODOS PARA TRATAMIENTOS ====================

    /**
     * Obtiene la lista completa de tratamientos.
     * @return Lista con todos los tratamientos.
     */
    public LinkedList<String> getTratamientos() {
        return tratamientos;
    }

    /**
     * Agrega un nuevo tratamiento (si no existe).
     * @param tratamiento Tratamiento a agregar.
     */
    public void agregarTratamiento(String tratamiento) {
        for (String s : tratamientos) {
            if (s.equals(tratamiento)) {
                return;  // Evita duplicados
            }
        }
        tratamientos.add(tratamiento);
    }

    /**
     * Busca un tratamiento específico.
     * @param tratamiento Tratamiento a buscar.
     * @return El tratamiento si existe, o null si no se encuentra.
     */
    public String revisarTratamiento(String tratamiento) {
        for (String s : tratamientos) {
            if (s.equals(tratamiento)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Elimina un tratamiento.
     * @param tratamiento Tratamiento a eliminar.
     */
    public void eliminartratamiento(String tratamiento) {
        if (revisarTratamiento(tratamiento) != null) {
            tratamientos.remove(tratamiento);
        }
    }

    // ==================== MÉTODOS HEREDADOS (GETTERS) ====================

    /**
     * Obtiene el nombre del paciente.
     * @return Nombre del paciente.
     */
    public String getNombre() {
        return super.getNombre();
    }

    /**
     * Obtiene el apellido del paciente.
     * @return Apellido del paciente.
     */
    public String getApellido() {
        return super.getApellido();
    }

    /**
     * Obtiene el ID del paciente.
     * @return Identificación única.
     */
    public String getId() {
        return super.getId();
    }

    /**
     * Obtiene el teléfono del paciente.
     * @return Número de teléfono.
     */
    public String getTelefono() {
        return super.getTelefono();
    }
}