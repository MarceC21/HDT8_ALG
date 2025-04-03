package Clasificador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VectorHeapTest {

    @Test
    void testAddAndRemove() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        
        Paciente p1 = new Paciente("Marcela", "Fractura", "C");
        Paciente p2 = new Paciente("Patricia", "Infarto", "A");
        Paciente p3 = new Paciente("Jorge", "Gripe", "E");

        heap.add(p1);
        heap.add(p2);
        heap.add(p3);

        assertEquals("Marcela", heap.remove().getNombre()); // Prioridad A
        assertEquals("Patricia", heap.remove().getNombre()); // Prioridad C
        assertEquals("Jorge", heap.remove().getNombre()); // Prioridad E
    }

    @Test
    void testIsEmpty() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        assertTrue(heap.isEmpty());

        heap.add(new Paciente("Laura", "Apendicitis", "A"));
        assertFalse(heap.isEmpty());

        heap.remove();
        assertTrue(heap.isEmpty());
    }
}
