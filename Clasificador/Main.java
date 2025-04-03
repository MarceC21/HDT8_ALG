package Clasificador;

//Los datos del archivo txt fueron proprcioandos por ChatGPT: https://chatgpt.com/share/67ef13b7-e51c-8007-b05e-fac6b96c38a2

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de PriorityQueue: (vector/java)");
        String tipo = scanner.nextLine().trim().toLowerCase();

        Clasificador.PriorityQueue<Paciente> colaPrioridad = Factory.getQueue(tipo);
        
        // Leer el archivo y agregar pacientes
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

