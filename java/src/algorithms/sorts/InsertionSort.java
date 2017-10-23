package algorithms.sorts;

import java.util.ArrayList;

/**
 * Insertion Sort Implementation
 */
public class InsertionSort  {

  public InsertionSort() {
    super();
  }

  /**
   * Sorts array in-place
   * O(n^2) worst case time complexity
   * O(n) best case time complexity (partially sorted array)
   * @param arr
   */
  public void sort(ArrayList<Integer> arr) {
    int j;
    for (int i = 1; i < arr.size(); i++) {
      int temp = arr.get(i);
      j = i;
      while (j > 0 && arr.get(j - 1) > temp) {
        arr.set(j, arr.get(j - 1));
        j--;
      }
      arr.set(j, temp);
    }
  }

}
