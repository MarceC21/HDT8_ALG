package Clasificador;

// Los datos del archivo txt fueron proporcionados por ChatGPT: https://chatgpt.com/share/67ef13b7-e51c-8007-b05e-fac6b96c38a2

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main
 * ===============================================================
 * Autor: Jorge Villeda y Marcela Castillo
 * Fecha: 03/04/25
 * Descripción: Clase principal que permite seleccionar un tipo de implementación 
 * de cola de prioridad, leer los datos de pacientes desde un archivo de texto 
 * y mostrarlos ordenados por prioridad utilizando la estructura seleccionada.
 */
public class Main {

    /**
     * Método principal que ejecuta el programa.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de PriorityQueue: (vector/java)");
        String tipo = scanner.nextLine().trim().toLowerCase();

        // Se obtiene la cola de prioridad según el tipo seleccionado por el usuario
        Clasificador.PriorityQueue<Paciente> colaPrioridad = Factory.getQueue(tipo);
        
        // Leer el archivo y agregar pacientes a la cola de prioridad
        try (BufferedReader br = new BufferedReader(new FileReader("Clasificador/pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    String enfermedad = datos[1].trim();
                    String prioridad = datos[2].trim();

                    Paciente paciente = new Paciente(nombre, enfermedad, prioridad);
                    colaPrioridad.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Mostrar pacientes en orden de prioridad
        System.out.println("\nPacientes en orden de prioridad:");
        while (!colaPrioridad.isEmpty()) {
            System.out.println(colaPrioridad.remove());
        }

        scanner.close();
    }
}
