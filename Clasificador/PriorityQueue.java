package Clasificador;
// Para esta clase se usó como recurso el libro de JavaStructures y el código de la interfaz proporcionado
/**
 * Interfaz PriorityQueue 
 * ===============================================================
 * Autor: Jorge Villeda y Marcela Castillo
 * Fecha: 03/04/25
 * Descripción: Interfaz PriorityQueue que define los métodos que se implementaran en las clases  .
 *
 * @param <E> Tipo de elementos que deben ser comparables.
 */
public interface PriorityQueue<E extends Comparable<E>>
{
	public E getFirst();
	// pre: !isEmpty()
	// post: returns the minimum value in priority queue
	
	public E remove();
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	
	public void add(E value);
	// pre: value is non-null comparable
	// post: value is added to priority queue
	
	public boolean isEmpty();
	// post: returns true iff no elements are in queue
	
	public int size();
	// post: returns number of elements within queue
	
	public void clear();
	// post: removes all elements from queue
}
