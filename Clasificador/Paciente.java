package Clasificador;

/**
 * Clase Paciente
 * ===============================================================
 * Autor: Jorge Villeda y Marcela Castillo
 * Fecha: 03/04/25
 * Descripción: Clase que representa a un paciente en un sistema de clasificación 
 * de prioridad médica. Implementa la interfaz Comparable para permitir ordenar 
 * pacientes según su nivel de prioridad (de la A a la E).
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String enfermedad;
    private String prioridad;

    /**
     * Constructor de la clase Paciente.
     *
     * @param nombre     Nombre del paciente.
     * @param enfermedad Enfermedad del paciente.
     * @param prioridad  Prioridad asignada al paciente (de A a E).
     */
    public Paciente(String nombre, String enfermedad, String prioridad) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.prioridad = prioridad;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la enfermedad del paciente.
     *
     * @return La enfermedad del paciente.
     */
    public String getEnfermedad() {
        return enfermedad;
    }

    /**
     * Obtiene la prioridad del paciente.
     *
     * @return La prioridad del paciente.
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Representación en forma de cadena del paciente.
     *
     * @return Una cadena con el nombre, enfermedad y prioridad del paciente.
     */
    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", enfermedad=" + enfermedad + ", prioridad=" + prioridad + "]";
    }

    /**
     * Compara a este paciente con otro según su prioridad.
     *
     * @param otro El otro paciente con el que se va a comparar.
     * @return Un valor negativo si este paciente tiene mayor prioridad,
     *         cero si tienen la misma, y positivo si tiene menor prioridad.
     */
    @Override
    public int compareTo(Paciente otro) {
        return getPrioridadNumerica(this.prioridad) - getPrioridadNumerica(otro.prioridad);
    }

    /**
     * Convierte una prioridad en forma de letra (A–E) a un valor numérico.
     *
     * @param prioridad Prioridad como cadena (A, B, C, D, E).
     * @return Un número entero correspondiente a la prioridad.
     * @throws IllegalArgumentException si la prioridad no es válida.
     */
    private int getPrioridadNumerica(String prioridad) {
        switch (prioridad) {
            case "A": return 1;
            case "B": return 2;
            case "C": return 3;
            case "D": return 4;
            case "E": return 5;
            default: throw new IllegalArgumentException("Prioridad inválida: " + prioridad);
        }
    }
}
