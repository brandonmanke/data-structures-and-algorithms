package data_structures.heap;

import java.util.ArrayList;

public class MinHeap<E> implements Heap<E> {
    private ArrayList<E> heap;
    private int size;

    public MinHeap() {
        heap = new ArrayList<>();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E peek() {
        if (heap.size() > 0) {
            return heap.get(0);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public boolean insert(E data) {
        return true;
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
        return true;
    }

    public MinHeap<E> merge(MinHeap<E> heap) {
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
