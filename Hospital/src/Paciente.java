import java.util.LinkedList;

/**
 * Clase que representa a un Paciente en un sistema médico.
 * Hereda de Administrador y gestiona su historial clínico y tratamientos.
 */
public class Paciente extends Administrador {

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
     * Reemplaza todo el historial clínico con una nueva lista.
     * @param historialClinico Nueva lista de historial clínico.
     */
    public void setHistorialClinico(LinkedList<String> historialClinico) {
        this.historialClinico = historialClinico;
    }

    /**
     * Agrega un nuevo registro al historial clínico (si no existe).
     * @param clinico Registro clínico a agregar.
     * @return true si se agregó, false si ya existía.
     */
    public Boolean agregarHistorialClinico(String clinico) {
        for (String s : historialClinico) {
            if (s.equals(clinico)) {
                return false;  // Evita duplicados
            }
        }
        return historialClinico.add(clinico);  // Agrega si no existe
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
     * Modifica un registro del historial clínico.
     * @param clinicoViejo Registro a modificar.
     * @param clinico      Nuevo registro.
     * @return true si se modificó, false si no existía el registro viejo.
     */
    public boolean modificarHistorialClinico(String clinicoViejo, String clinico) {
        if (revisarHistorialClinico(clinicoViejo) != null) {
            historialClinico.remove(clinicoViejo);
            historialClinico.add(clinico);
            return true;  // Modificación exitosa
        }
        return false;  // Registro viejo no encontrado
    }

    /**
     * Elimina un registro del historial clínico.
     * @param clinico Registro a eliminar.
     * @return true si se eliminó, false si no existía.
     */
    public boolean eliminarHistorialClinico(String clinico) {
        if (revisarHistorialClinico(clinico) != null) {
            return historialClinico.remove(clinico);  // Elimina y retorna true
        }
        return false;  // No se encontró el registro
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
     * Reemplaza todos los tratamientos con una nueva lista.
     * @param tratamientos Nueva lista de tratamientos.
     */
    public void setTratamientos(LinkedList<String> tratamientos) {
        this.tratamientos = tratamientos;
    }

    /**
     * Agrega un nuevo tratamiento (si no existe).
     * @param tratamiento Tratamiento a agregar.
     * @return true si se agregó, false si ya existía.
     */
    public Boolean agregarTratamiento(String tratamiento) {
        for (String s : tratamientos) {
            if (s.equals(tratamiento)) {
                return false;  // Evita duplicados
            }
        }
        return tratamientos.add(tratamiento);  // Agrega si no existe
    }

    /**
     * Busca un tratamiento específico.
     * @param tratamiento Tratamiento a buscar.
     * @return El tratamiento si existe, o null si no se encuentra.
     */
    public String revisarTratamiento(String tratamiento) {
        for (String s : tratamientos) {
            if (s.equals(tratamiento)) {
                return s;  // Retorna el tratamiento encontrado
            }
        }
        return null;  // No encontrado
    }

    /**
     * Modifica un tratamiento existente.
     * @param tratamientoViejo Tratamiento a modificar.
     * @param tratamiento      Nuevo tratamiento.
     * @return true si se modificó, false si no existía el tratamiento viejo.
     */
    public boolean modificarTratamiento(String tratamientoViejo, String tratamiento) {
        if (revisarTratamiento(tratamientoViejo) != null) {
            tratamientos.remove(tratamientoViejo);
            tratamientos.add(tratamiento);
            return true;  // Modificación exitosa
        }
        return false;  // Tratamiento viejo no encontrado
    }

    /**
     * Elimina un tratamiento.
     * @param tratamiento Tratamiento a eliminar.
     * @return true si se eliminó, false si no existía.
     */
    public boolean eliminartratamiento(String tratamiento) {
        if (revisarTratamiento(tratamiento) != null) {
            return tratamientos.remove(tratamiento);  // Elimina y retorna true
        }
        return false;  // No se encontró el tratamiento
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