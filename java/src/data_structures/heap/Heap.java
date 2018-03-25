package data_structures.heap;

public interface Heap<E> {
    int size();
    boolean isEmpty();
    E peek(); // max or min (depending on heap)
    boolean insert(E data); // or 'pop'
    E pop();
    boolean replace(E key);
    //Heap<E> merge(Heap<E> heap);
    // private
    //void heapify();
    //boolean delete(int index);
}
