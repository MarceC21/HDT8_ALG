package Clasificador;

import java.util.PriorityQueue;

//Para esta clase se uso de recursos el libro de JavaStructures 
//y se uso tambien el siguiente recurso: http://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html

public class PriorityQueueJava<E extends Comparable<E>> implements Clasificador.PriorityQueue<E> {
    private PriorityQueue<E> queue;

    public PriorityQueueJava() {
        queue = new PriorityQueue<>();
    }

    @Override
    public E getFirst() {
        return queue.peek();
    }

    @Override
    public E remove() {
        return queue.poll();
    }

    @Override
    public void add(E value) {
        queue.offer(value);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void clear() {
        queue.clear();
    }
}

