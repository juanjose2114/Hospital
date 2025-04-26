package co.edu.uniquindio.proyecto_ejemplo_javafx.model;

/**
 * Clase abstracta persona usada en Sala y Citas.
 * Contiene la información básica de identificación y contacto de una Persona.
 * Esta clase sirve como base para otras clases como Administrador, Médico y Paciente.
 */
public abstract class Persona {

    // Atributos básicos de identificación
    private String nombre;     // Nombre del administrador
    private String apellido;   // Apellido del administrador
    private String id;        // Identificación única (ej: cédula o ID empleado)
    private String telefono;   // Número de contacto

    public Persona(String nombre, String apellido, String id, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}