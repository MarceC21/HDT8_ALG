package Clasificador;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String enfermedad;
    private String prioridad;

    public Paciente(String nombre, String enfermedad, String prioridad) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", enfermedad=" + enfermedad + ", prioridad=" + prioridad + "]";
    }

    @Override
    public int compareTo(Paciente otro) {
        return getPrioridadNumerica(this.prioridad) - getPrioridadNumerica(otro.prioridad);
    }
    

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
