/**
 * Clase que representa a un Administrador en el sistema hospitalario.
 * Contiene la información básica de identificación y contacto de los administradores.
 * Esta clase sirve como base para otras clases como Médico y Paciente.
 */
public class Administrador {

    // Atributos básicos de identificación
    private String nombre;     // Nombre del administrador
    private String apellido;   // Apellido del administrador
    private String id;        // Identificación única (ej: cédula o ID empleado)
    private String telefono;   // Número de contacto

    /**
     * Constructor para crear un nuevo Administrador.
     * @param nombre   Nombre del administrador (ej: "Juan")
     * @param apellido Apellido del administrador (ej: "Pérez")
     * @param id       Identificación única (ej: "ADM-12345")
     * @param telefono Número de contacto (ej: "+52 5512345678")
     */
    public Administrador(String nombre, String apellido, String id, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.telefono = telefono;
    }

    // ==================== MÉTODOS ACCESORES ====================

    /**
     * Obtiene el nombre del administrador.
     * @return Nombre actual del administrador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el administrador.
     * @param nombre Nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del administrador.
     * @return Apellido actual del administrador.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece un nuevo apellido para el administrador.
     * @param apellido Nuevo apellido a asignar.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la identificación del administrador.
     * @return ID actual del administrador.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece una nueva identificación para el administrador.
     * @param id Nueva identificación a asignar.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el número de teléfono del administrador.
     * @return Teléfono actual del administrador.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece un nuevo número de teléfono para el administrador.
     * @param telefono Nuevo número de contacto a asignar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}