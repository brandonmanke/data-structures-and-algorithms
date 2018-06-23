package algorithms;

import java.util.ArrayList;

/**
 * Heap Sort Implementation
 */
public class HeapSort<E> {

  public HeapSort() {
    super();
  }

  /**
   * Sorts array of elements in O(nlogn)
   * Returns a "shallow copy" of the sorted array.
   * @param arr
   * @return Sorted array
   */
  public ArrayList sort(ArrayList<Integer> arr) {
    ArrayList<Integer> result = arr;
    int size = arr.size();
    for (int i = size / 2 - 1; i >= 0; i--) {
      heapify(result, size, i);
    }
    for (int i = size - 1; i >= 0; i--) {
      int swap = result.get(0);
      result.set(0, result.get(i));
      result.set(i, swap);
      heapify(result, i, 0);
    }
    return result;
  }

  /**
   * Reorders elements of array into max binary heap.
   * @param arr
   * @param size
   * @param index of parent node we are comparing
   */
  private void heapify(ArrayList<Integer> arr, int size, int index) {
    int largest = index;
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    if (left < size && arr.get(left) > arr.get(largest)) {
      largest = left;
    }
    if (right < size && arr.get(right) > arr.get(largest)) {
      largest = right;
    }
    if (largest != index) {
      int swap = arr.get(index);
      arr.set(index, arr.get(largest));
      arr.set(largest, swap);
      heapify(arr, size, largest);
    }
  }
}
