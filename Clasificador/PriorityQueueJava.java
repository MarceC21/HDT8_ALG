package Clasificador;

import java.util.PriorityQueue;

// Para esta clase se usó como recursos el libro de JavaStructures 
// y también el siguiente recurso: http://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html

/**
 * PriorityQueue con JFC
 * ===============================================================
 * Autor: Jorge Villeda y Marcela Castillo
 * Fecha: 03/04/25
 * Descripción: Implementación de una cola de prioridad utilizando la clase
 * PriorityQueue de Java. Esta clase implementa la interfaz PriorityQueue
 * definida dentro del paquete Clasificador.
 *
 * @param <E> Tipo de elementos que deben ser comparables.
 */
public class PriorityQueueJava<E extends Comparable<E>> implements Clasificador.PriorityQueue<E> {
    private PriorityQueue<E> queue;

    /**
     * Constructor que inicializa la cola de prioridad interna.
     */
    public PriorityQueueJava() {
        queue = new PriorityQueue<>();
    }

    /**
     * Retorna el primer elemento de la cola sin removerlo.
     *
     * @return Elemento con la mayor prioridad o null si la cola está vacía.
     */
    @Override
    public E getFirst() {
        return queue.peek();
    }

    /**
     * Remueve y retorna el elemento con mayor prioridad.
     *
     * @return Elemento con mayor prioridad o null si la cola está vacía.
     */
    @Override
    public E remove() {
        return queue.poll();
    }

    /**
     * Agrega un nuevo elemento a la cola de prioridad.
     *
     * @param value Elemento a agregar.
     */
    @Override
    public void add(E value) {
        queue.offer(value);
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Retorna el número de elementos en la cola.
     *
     * @return Tamaño de la cola.
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     * Elimina todos los elementos de la cola.
     */
    @Override
    public void clear() {
        queue.clear();
    }
}

