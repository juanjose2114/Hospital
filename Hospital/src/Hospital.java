import java.util.ArrayList;

/**
 * Clase que representa un Hospital en un sistema de gestión médica.
 * Gestiona salas de atención, citas médicas y la información básica del hospital.
 */
public class Hospital {

    // Matriz para representar las salas del hospital:
    // - Cada fila representa una sala
    // - Columnas: [0] ID de cita, [1] ID de médico, [2] ID de paciente
    private String[][] salas;

    // Nombre del hospital
    private String nombre;

    // Lista de citas programadas en el hospital
    private ArrayList<Cita> citas;

    /**
     * Constructor para crear un nuevo Hospital.
     * @param nombre Nombre del hospital (ej: "Hospital General").
     */
    public Hospital(String nombre) {
        this.nombre = nombre;
        this.salas = new String[100][3]; // 100 salas con capacidad para 3 datos cada una
        this.citas = new ArrayList<>();
    }

    // ==================== MÉTODOS BÁSICOS DEL HOSPITAL ====================

    /**
     * Obtiene el nombre del hospital.
     * @return Nombre actual del hospital.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el hospital.
     * @param nombre Nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // ==================== MÉTODOS PARA GESTIÓN DE SALAS ====================

    /**
     * Obtiene la matriz completa de salas.
     * @return Matriz donde cada fila representa una sala y sus datos.
     */
    public String[][] getSalas() {
        return salas;
    }

    /**
     * Reemplaza toda la configuración de salas.
     * @param salas Nueva matriz de salas a asignar.
     */
    public void setSalas(String[][] salas) {
        this.salas = salas;
    }

    /**
     * Asigna una cita, médico y paciente a una sala disponible.
     * @param cita Cita médica a asignar.
     * @param medico Médico que atenderá la cita.
     * @param paciente Paciente que será atendido.
     * @return true si se asignó correctamente, false si no hay salas disponibles o la cita no está activa.
     */
    public boolean ocuparSala(Cita cita, Medico medico, Paciente paciente) {
        if (!cita.getEstado()) {
            for (int i = 0; i < salas.length; i++) {
                if (salas[i][0] == null) { // Busca sala disponible (sin cita asignada)
                    salas[i][0] = cita.getId();
                    salas[i][1] = medico.getId();
                    salas[i][2] = paciente.getId();
                    return true;
                }
            }
        }
        return false;
    }

    // ==================== MÉTODOS PARA GESTIÓN DE CITAS ====================

    /**
     * Obtiene la lista completa de citas del hospital.
     * @return ArrayList con todas las citas registradas.
     */
    public ArrayList<Cita> getCitas() {
        return citas;
    }

    /**
     * Reemplaza toda la lista de citas del hospital.
     * @param citas Nueva lista de citas a asignar.
     */
    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    /**
     * Agrega una nueva cita al sistema del hospital.
     * @param cita Cita a agregar.
     * @return true si se agregó correctamente, false si ya existía una cita con el mismo ID.
     */
    public boolean agregarCita(Cita cita) {
        if (buscarCita(cita.getId()) == null) {
            return citas.add(cita);
        }
        return false;
    }

    /**
     * Busca una cita por su ID.
     * @param id Identificador único de la cita.
     * @return La cita encontrada o null si no existe.
     */
    public Cita buscarCita(String id) {
        for (Cita cita : citas) {
            if (cita.getId().equals(id)) {
                return cita;
            }
        }
        return null;
    }

    /**
     * Modifica los datos de una cita existente.
     * @param cita Cita con los nuevos datos a actualizar.
     * @return true si se modificó correctamente, false si la cita no existía.
     */
    public boolean modificarCita(Cita cita) {
        Cita citaExistente = buscarCita(cita.getId());
        if (citaExistente != null) {
            citas.remove(citaExistente);
            return citas.add(cita);
        }
        return false;
    }

    /**
     * Elimina una cita del sistema.
     * @param id Identificador de la cita a eliminar.
     * @return true si se eliminó correctamente, false si la cita no existía.
     */
    public boolean eliminarCita(String id) {
        Cita cita = buscarCita(id);
        if (cita != null) {
            return citas.remove(cita);
        }
        return false;
    }
}