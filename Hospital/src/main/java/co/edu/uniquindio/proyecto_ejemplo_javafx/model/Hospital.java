package co.edu.uniquindio.proyecto_ejemplo_javafx.model;

import java.util.ArrayList;

/**
 * Clase que representa un Hospital en un sistema de gestión médica.
 * Gestiona salas de atención, citas médicas, pacientes, administradores
 * y toda la información operativa del hospital.
 */
public class Hospital {

    /**
     * Arreglo de salas disponibles en el hospital.
     */
    private Sala[] salas;

    /**
     * Número total de salas en el hospital.
     */
    private int n_salas;

    /**
     * Lista de pacientes registrados en el hospital.
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Lista de administradores del sistema hospitalario.
     */
    private ArrayList<Administrador> administradores;

    /**
     * Lista de medicos del sistema hospitalario
     */
    private ArrayList<Medico> medicos;

    /**
     * Nombre oficial del hospital.
     */
    private String nombre;

    /**
     * Lista de citas médicas programadas.
     */
    private ArrayList<Cita> citas;

    // ==================== CONSTRUCTOR ====================

    /**
     * Constructor para crear un nuevo Hospital.
     * @param nombre Nombre del hospital (no puede ser nulo o vacío)
     * @param n_salas Número de salas a crear (debe ser mayor que 0)
     * @throws IllegalArgumentException Si el nombre es nulo/vacío o el número de salas es inválido
     */
    public Hospital(String nombre, int n_salas) {

        this.nombre = nombre;
        this.pacientes = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.salas = new Sala[n_salas];
        this.citas = new ArrayList<>();

        // Inicializar salas con IDs consecutivos
        for(int i = 0; i < n_salas; i++) {
            int n = i + 1;
            String m = n + "";
            salas[i] = new Sala(m);
        }

        //administrador principal, necesario para el manejo inicial del hospital
        Administrador admin = new Administrador("Juan", "Arias", "1", "1");
        administradores.add(admin);

        //medico basico para comprobar funcionamiento
        Medico medico1 = new Medico("medico1", "Basico", "id1", "123", "12", "13");
        medicos.add(medico1);

        Medico medico2 = new Medico("medico2", "Basico", "id2", "123", "13", "14");
        medicos.add(medico2);
    }

    // ==================== MÉTODOS BÁSICOS ====================

    /**
     * Obtiene el nombre del hospital.
     * @return Nombre actual del hospital.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el hospital.
     * @param nombre Nuevo nombre a asignar (no puede ser nulo o vacío)
     * @throws IllegalArgumentException Si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de pacientes registrados.
     * @return Copia defensiva de la lista de pacientes.
     */
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * Obtiene la lista de administradores del sistema.
     * @return Copia defensiva de la lista de administradores.
     */
    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    // ==================== GESTIÓN DE ADMINISTRADORES ====================

    /**
     * Crea y agrega un nuevo administrador al sistema.
     * @param administrador Administrador a agregar (no nulo)
     * @return true si se agregó correctamente, false si ya existía
     */
    public boolean crearAdministrador(String idAdmin, Administrador administrador) {
        if(buscarAdministrador(idAdmin) != null) {
            if(buscarAdministrador(administrador.getNombre()) != null) {
                if (buscarAdministrador(administrador.getId()) == null) {
                    return administradores.add(administrador);
                }
            }
        }
        return false;
    }

    /**
     * Busca un administrador por su ID.
     * @param id Identificador del administrador
     * @return Administrador encontrado o null si no existe
     */
    public Administrador buscarAdministrador(String id) {
        for(Administrador admin : administradores) {
            if(admin.getId().equals(id)) {
                return admin;
            }
        }
        return null;
    }

    /**
     * Modifica los datos de un administrador existente.
     * @param administrador Administrador con datos actualizados
     * @return true si se modificó correctamente, false si no existía
     */
    public boolean modificarAdministrador(Administrador administrador) {
        if(buscarAdministrador(administrador.getNombre()) != null) {
            administradores.remove(buscarAdministrador(administrador.getId()));
            return administradores.add(administrador);
        }
        return false;
    }

    public boolean eliminarAdministrador(String id) {
        if (buscarAdministrador(id) != null) {
            return administradores.remove(buscarAdministrador(id));
        }
        return false;
    }

    // ==================== GESTIÓN DE MEDICOS ====================

    /**
     * Crea y agrega un nuevo medico al sistema.
     * @param medico Medico a agregar (no nulo)
     * @return true si se agregó correctamente, false si ya existía
     */
    public boolean crearMedico(Medico medico) {
        if(buscarMedico(medico.getId()) == null) {
            System.out.println("medico creado");
            return medicos.add(medico);
        }
        System.out.println("medico no creado");
        return false;
    }

    /**
     * Busca un medico por su ID.
     * @param id Identificador del medico
     * @return Medico encontrado o null si no existe
     */
    public Medico buscarMedico(String id) {
        for(Medico medico : medicos) {
            if(medico.getId().equals(id)) {
                System.out.println("medico buscado y retornado");
                return medico;
            }
        }
        System.out.println("medico no encontrado");
        return null;
    }

    /**
     * Modifica los datos de un medico existente.
     * @param medico Medico con datos actualizados
     * @return true si se modificó correctamente, false si no existía
     */
    public boolean modificarMedico(Medico medico) {
        if(buscarMedico(medico.getNombre()) != null) {
            System.out.println("medico modificado");
            medicos.remove(buscarMedico(medico.getId()));
            return medicos.add(medico);
        }
        System.out.println("medico no encontrado");
        return false;
    }

    /**
     * Elimina un medico del sistema.
     * @param idAdmin ID del administrador que realiza la operación
     * @param idMedico Identificador del paciente a eliminar
     * @return true si se eliminó correctamente, false si no existía o el admin no es válido
     */
    public boolean eliminarMedico(String idAdmin, String idMedico) {
        if(buscarAdministrador(idAdmin) != null) {
            if (buscarMedico(idMedico) != null) {
                return medicos.remove(buscarMedico(idMedico));
            }
        }
        return false;
    }

    // ==================== GESTIÓN DE PACIENTES ====================

    /**
     * Crea y agrega un nuevo paciente al sistema.
     * @param idAdmin ID del administrador que realiza la operación
     * @param paciente Paciente a agregar (no nulo)
     * @return true si se agregó correctamente, false si ya existía o el admin no es válido
     */
    public boolean crearPaciente(String idAdmin, Paciente paciente) {
        if(buscarAdministrador(idAdmin) != null) {
            if(buscarAdministrador(idAdmin) != null && buscarPaciente(idAdmin, paciente.getId()) == null) {
                return pacientes.add(paciente);
            }
        }
        return false;
    }

    /**
     * Busca un paciente por su ID.
     * @param idAdmin ID del administrador que realiza la consulta
     * @param id Identificador del paciente
     * @return Paciente encontrado o null si no existe
     */
    public Paciente buscarPaciente(String idAdmin, String id) {
        if(buscarAdministrador(idAdmin) != null) {
            for(Paciente paciente : pacientes) {
                if(paciente.getId().equals(id)) {
                    return paciente;
                }
            }
        }
        return null;
    }

    /**
     * Modifica los datos de un paciente existente.
     * @param idAdmin ID del administrador que realiza la operación
     * @param paciente Paciente con datos actualizados
     * @return true si se modificó correctamente, false si no existía o el admin no es válido
     * @throws IllegalArgumentException Si el paciente es nulo
     */
    public boolean modificarPaciente(String idAdmin, Paciente paciente) {
        if(buscarPaciente(idAdmin, paciente.getId()) != null) {
            if(buscarAdministrador(idAdmin) != null) {
                pacientes.remove(buscarPaciente(idAdmin, paciente.getId()));
                return pacientes.add(paciente);
            }
        }
        return false;
    }

    /**
     * Elimina un paciente del sistema.
     * @param idAdmin ID del administrador que realiza la operación
     * @param idPaciente Identificador del paciente a eliminar
     * @return true si se eliminó correctamente, false si no existía o el admin no es válido
     */
    public boolean eliminarPaciente(String idAdmin, String idPaciente) {
        if(buscarAdministrador(idAdmin) != null) {
            return pacientes.removeIf(p -> p.getId().equals(idPaciente));
        }
        return false;
    }

    // ==================== GESTIÓN DE SALAS ====================

    /**
     * Obtiene el arreglo completo de salas.
     * @return Copia defensiva del arreglo de salas
     */
    public Sala[] getSalas() {
        return salas;
    }


    /**
     * Busca una sala por su ID.
     * @param idSala Identificador de la sala
     * @return Sala encontrada o null si no existe
     */
    public Sala buscarSala(String idSala) {
        for(Sala sala : salas) {
            if(sala != null && sala.getIdsala().equals(idSala)) {
                return sala;
            }
        }
        return null;
    }

    /**
     * Ocupa una sala con los ocupantes y cita especificados.
     * @param idSala Identificador de la sala a ocupar
     * @param ocupantes Lista de personas que ocuparán la sala
     * @param idcita Cita médica asociada
     * @return true si se ocupó correctamente, false si la sala no existe o no está disponible
     */
    public boolean ocuparSala(String idSala, ArrayList<Persona> ocupantes, String idcita){
        Sala sala = buscarSala(idSala);
        if(sala != null){
            if (!ocupantes.isEmpty()){
                for(Persona persona : ocupantes) {
                    sala.agregarOcupante(persona);
                }
            }
            if (!idcita.isBlank()) {
                sala.setCita(buscarCita(idcita));
            }
            return true;
        }
        return false;
    }

    public void vaciarSala(String idSala){
        Sala sala = buscarSala(idSala);
        if(sala != null){
            sala.setCita(null);
            sala.setDisponibilidad(true);
            sala.vaciarSala();
        }
    }

    // ==================== GESTIÓN DE CITAS ====================

    /**
     * Obtiene la lista completa de citas.
     * @return Copia defensiva de la lista de citas
     */
    public ArrayList<Cita> getCitas() {
        return new ArrayList<>(citas);
    }

    /**
     * Agrega una nueva cita al sistema.
     * @param cita Cita a agregar (no nula)
     * @return true si se agregó correctamente, false si ya existía
     */
    public boolean agregarCita(Cita cita) {
        if(buscarCita(cita.getId()) != null) {
            if(buscarCita(cita.getId()) == null) {
                return citas.add(cita);
            }
        }
        return false;
    }

    /**
     * Busca una cita por su ID.
     * @param id Identificador de la cita
     * @return Cita encontrada o null si no existe
     */
    public Cita buscarCita(String id) {
        for(Cita cita : citas) {
            if(cita.getId().equals(id)) {
                return cita;
            }
        }
        return null;
    }

    /**
     * Modifica los datos de una cita existente.
     * @param cita Cita con datos actualizados
     * @return true si se modificó correctamente, false si no existía
     */
    public boolean modificarCita(Cita cita) {
        if(buscarCita(cita.getId()) != null) {
            Cita existente = buscarCita(cita.getId());
            if(existente != null) {
                citas.remove(existente);
                return citas.add(cita);
            }
        }
        return false;
    }

    /**
     * Elimina una cita del sistema.
     * @param id Identificador de la cita a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    public boolean eliminarCita(String id) {
        Cita cita = buscarCita(id);
        if(cita != null) {
            return citas.remove(cita);
        }
        return false;
    }

    // ==================== MÉTODOS AUXILIARES ====================

    /**
     * Verifica si el hospital tiene salas disponibles.
     * @return true si hay al menos una sala disponible, false en caso contrario
     */
    public boolean haySalasDisponibles() {
        for(Sala sala : salas) {
            if(sala.getDisponibilidad()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Hospital [Nombre: %s, Salas: %d, Pacientes: %d, Citas: %d]",
                nombre, n_salas, pacientes.size(), citas.size());
    }


}