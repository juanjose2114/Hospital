package co.edu.uniquindio.proyecto_ejemplo_javafx.model;

/**
 * Clase abstracta que representa la información básica de una persona.
 * Sirve como clase base para entidades como Administrador, Médico y Paciente.
 * Contiene los datos fundamentales de identificación y contacto.
 */
public abstract class Persona {

    // ==================== ATRIBUTOS ====================

    /**
     * Nombre de pila de la persona (ej: "Carlos", "María").
     */
    private String nombre;

    /**
     * Apellido(s) de la persona (ej: "Gómez", "Pérez López").
     */
    private String apellido;

    /**
     * Identificador único de la persona:
     * - Puede ser cédula, pasaporte o ID institucional.
     * - Formato depende del tipo de persona.
     */
    private String id;

    /**
     * Número de teléfono de contacto:
     * - Almacenado como String para permitir formatos variados.
     * - Ej: "3201234567", "+57 310 123 4567"
     */
    private String telefono;

    // ==================== CONSTRUCTOR ====================

    /**
     * Crea una nueva instancia de Persona con todos sus datos básicos.
     * @param nombre Nombre de pila de la persona.
     * @param apellido Apellido(s) de la persona.
     * @param id Identificación única (cédula/pasaporte/ID).
     * @param telefono Número de contacto telefónico.
     */
    public Persona(String nombre, String apellido, String id, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.telefono = telefono;
    }

    // ==================== MÉTODOS DE ACCESO ====================

    /**
     * Obtiene el nombre de la persona.
     * @return Nombre actual de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para la persona.
     * @param nombre Nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     * @return Apellido(s) actual(es) de la persona.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece un nuevo apellido para la persona.
     * @param apellido Nuevo apellido a asignar.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el identificador único de la persona.
     * @return ID actual (cédula/pasaporte/ID institucional).
     */
    public String getId() {
        return id;
    }

    /**
     * Establece un nuevo identificador para la persona.
     * @param id Nueva identificación a asignar.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el número de teléfono de contacto.
     * @return Número telefónico actual.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece un nuevo número de teléfono de contacto.
     * @param telefono Nuevo número telefónico a asignar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}