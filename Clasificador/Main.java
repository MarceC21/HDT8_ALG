package Clasificador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                try {

                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.out.println("Error en la expresión: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
