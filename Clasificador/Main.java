package Clasificador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        VectorHeap<Paciente> colaPrioridad = new VectorHeap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Clasificador/pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Separar por coma
                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    String enfermedad = datos[1].trim();
                    String prioridad = datos[2].trim();

                    Paciente paciente = new Paciente(nombre, enfermedad, prioridad);
                    colaPrioridad.add(paciente); // Se añade y automáticamente usa percolateUp()
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("\nPacientes en orden de prioridad:");
        while (!colaPrioridad.isEmpty()) {
            System.out.println(colaPrioridad.remove()); // Se extrae en orden de prioridad
        }
    }
}
