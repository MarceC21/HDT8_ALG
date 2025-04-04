package Clasificador;

/**
 * Factory
 * ===============================================================
 * Autor: Jorge Villeda y Marcela Castillo
 * Fecha: 03/04/25
 * Descripción: Clase Factory que implementa el patrón de diseño Factory para 
 * instanciar diferentes tipos de colas de prioridad según el tipo solicitado. 
 * Las colas deben implementar la interfaz Clasificador.PriorityQueue.
 */
public class Factory {

    /**
     * Devuelve una instancia de una cola de prioridad basada en el tipo solicitado.
     *
     * @param <E>  Tipo de elementos que extienden Comparable.
     * @param type Tipo de implementación de la cola ("vector" o "java").
     * @return Una instancia de una implementación de PriorityQueue.
     * @throws IllegalArgumentException si el tipo no es reconocido.
     */
    public static <E extends Comparable<E>> Clasificador.PriorityQueue<E> getQueue(String type) {
        if (type.equalsIgnoreCase("vector")) {
            return new VectorHeap<>();
        } else if (type.equalsIgnoreCase("java")) {
            return new PriorityQueueJava<>();
        } else {
            throw new IllegalArgumentException("Tipo de cola no válido: " + type);
        }
    }
}

