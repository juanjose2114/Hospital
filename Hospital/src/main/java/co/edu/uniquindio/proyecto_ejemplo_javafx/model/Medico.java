package co.edu.uniquindio.proyecto_ejemplo_javafx.model;

/**
 * Clase que representa a un Médico en un sistema de administración médica.
 * Hereda de la clase Administrador y añade información específica de horarios.
 */
public class Medico extends Administrador {

    // Atributo único del médico: su horario de atención
    private String horario;

    /**
     * Constructor para crear un nuevo Médico.
     * @param nombre    Nombre del médico.
     * @param apellido  Apellido del médico.
     * @param id        Identificación única (ej: cédula profesional).
     * @param telefono  Número de contacto.
     * @param horario   Horario de atención (ej: "Lunes a Viernes, 9:00 - 17:00").
     */
    public Medico(String nombre, String apellido, String id, String telefono, String horario) {
        super(nombre, apellido, id, telefono);  // Llama al constructor de Administrador
        this.horario = horario;  // Asigna el horario específico del médico
    }

    // ==================== MÉTODOS ESPECÍFICOS DEL MÉDICO ====================

    /**
     * Obtiene el horario de atención del médico.
     * @return String con el horario (ej: "Lunes a Viernes, 9:00 - 17:00").
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Actualiza el horario de atención del médico.
     * @param horario Nuevo horario (ej: "Martes y Jueves, 10:00 - 18:00").
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    // ==================== MÉTODOS HEREDADOS (GETTERS/SETTERS) ====================

    /**
     * Obtiene el nombre del médico (heredado de Administrador).
     * @return Nombre del médico.
     */
    @Override
    public String getNombre() {
        return super.getNombre();
    }

    /**
     * Actualiza el nombre del médico (heredado de Administrador).
     * @param nombre Nuevo nombre.
     */
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    /**
     * Obtiene el apellido del médico (heredado de Administrador).
     * @return Apellido del médico.
     */
    @Override
    public String getApellido() {
        return super.getApellido();
    }

    /**
     * Actualiza el apellido del médico (heredado de Administrador).
     * @param apellido Nuevo apellido.
     */
    @Override
    public void setApellido(String apellido) {
        super.setApellido(apellido);
    }

    /**
     * Obtiene el ID del médico (heredado de Administrador).
     * @return Identificación única (ej: cédula profesional).
     */
    @Override
    public String getId() {
        return super.getId();
    }

    /**
     * Actualiza el ID del médico (heredado de Administrador).
     * @param id Nuevo ID.
     */
    @Override
    public void setId(String id) {
        super.setId(id);
    }

    /**
     * Obtiene el teléfono del médico (heredado de Administrador).
     * @return Número de contacto.
     */
    @Override
    public String getTelefono() {
        return super.getTelefono();
    }

    /**
     * Actualiza el teléfono del médico (heredado de Administrador).
     * @param telefono Nuevo número de contacto.
     */
    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }
}