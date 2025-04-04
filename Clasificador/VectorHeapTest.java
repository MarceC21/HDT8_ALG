package Clasificador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Titulo
 * ===============================================================
 * Autor: Jorge Villeda y Marcela Castillo
 * Fecha: 03/04/25
 * Descripción: Clase de pruebas unitarias para la clase VectorHeap. Se utiliza 
 * JUnit para verificar el comportamiento del método add, remove y isEmpty.
 */
public class VectorHeapTest {

    /**
     * Verifica que los elementos se agreguen correctamente al heap
     * y se remuevan en el orden correcto de acuerdo con su prioridad.
     */
    @Test
    void testAddAndRemove() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        
        Paciente p1 = new Paciente("Marcela", "Fractura", "C");
        Paciente p2 = new Paciente("Patricia", "Infarto", "A");
        Paciente p3 = new Paciente("Jorge", "Gripe", "E");

        heap.add(p1);
        heap.add(p2);
        heap.add(p3);

        // Se espera que Patricia sea la primera (prioridad A), luego Marcela (C), y Jorge (E)
        assertEquals("Patricia", heap.remove().getNombre()); // Prioridad A
        assertEquals("Marcela", heap.remove().getNombre());  // Prioridad C
        assertEquals("Jorge", heap.remove().getNombre());    // Prioridad E
    }

    /**
     * Verifica el funcionamiento del método isEmpty para asegurar
     * que el heap reconozca correctamente si está vacío o no.
     */
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

