package Clasificador;

public class Factory {
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
