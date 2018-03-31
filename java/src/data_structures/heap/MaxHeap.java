package data_structures.heap;

import java.util.ArrayList;

public class MaxHeap<E> implements Heap<E> {
    private ArrayList<E> heap;
    private int size;

    public MaxHeap() {
        heap = new ArrayList<>();
        size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean insert(E data) {
        return false;
    }

    @Override
    public E pop() {
        if (heap.size() > 0) {
            E removed = heap.get(0);
            // remove and heapify
            return removed;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public boolean replace(E key) {
        return false;
    }

    public Heap merge(MaxHeap<E> heap) {
        return null;
    }

    // private methods

    private void heapify() {
        return;
    }

    private boolean delete(int index) {
        return true;
    }
}
