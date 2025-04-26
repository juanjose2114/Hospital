package co.edu.uniquindio.proyecto_ejemplo_javafx.model;

/**
 * Clase que representa a un Administrador en el sistema hospitalario.
 * Contiene la información básica de identificación y contacto de los administradores.
 * Esta clase sirve como base para otras clases como Médico y Paciente.
 */
public class Administrador extends Persona {

    /**
     * Constructor para crear un nuevo Administrador.
     * @param nombre   Nombre del administrador (ej: "Juan")
     * @param apellido Apellido del administrador (ej: "Pérez")
     * @param id       Identificación única (ej: "ADM-12345")
     * @param telefono Número de contacto (ej: "+52 5512345678")
     */
    public Administrador(String nombre, String apellido, String id, String telefono) {
        super(nombre, apellido, id, telefono);
    }

    // ==================== MÉTODOS ACCESORES ====================

    /**
     * Obtiene el nombre del administrador.
     * @return Nombre actual del administrador.
     */
    public String getNombre() {
        return super.getNombre();
    }

    /**
     * Establece un nuevo nombre para el administrador.
     * @param nombre Nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    /**
     * Obtiene el apellido del administrador.
     * @return Apellido actual del administrador.
     */
    public String getApellido() {
        return super.getApellido();
    }

    /**
     * Establece un nuevo apellido para el administrador.
     * @param apellido Nuevo apellido a asignar.
     */
    public void setApellido(String apellido) {
        super.setApellido(apellido);
    }

    /**
     * Obtiene la identificación del administrador.
     * @return ID actual del administrador.
     */
    public String getId() {
        return super.getId();
    }

    /**
     * Establece una nueva identificación para el administrador.
     * @param id Nueva identificación a asignar.
     */
    public void setId(String id) {
        super.setId(id);
    }

    /**
     * Obtiene el número de teléfono del administrador.
     * @return Teléfono actual del administrador.
     */
    public String getTelefono() {
        return super.getTelefono();
    }

    /**
     * Establece un nuevo número de teléfono para el administrador.
     * @param telefono Nuevo número de contacto a asignar.
     */
    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }
}