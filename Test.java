import java.util.Random;

class Test {

    public static int[] sort(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        quickSort(arr, l, r);
        return arr;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivotIndex = new Random().nextInt(r - l + 1) + l; // [l, r]
            int newPivotIndex = partition(arr, l, r, pivotIndex);
            quickSort(arr, l, newPivotIndex);
            quickSort(arr, newPivotIndex + 1, r);
        }
    }

    public static int partition(int[] arr, int l, int r, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, r); // swap pivot w/ right bound?/wall

        int j = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < pivot) {
                swap(arr, j++, i);
            }
        }
        swap(arr, r, j); // move pivot to true index of pivot
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }

    public static void main(String[] args) {
        int[] sorted = sort(new int[] {5, 6, 2, 1, 5, 7, 9 , 10, 20, 44, 32, 16, 19, 21, 29, 6, 3, 4});
        System.out.print("{ ");
        for (int i : sorted) {
            System.out.print(i + ",");
        }
        System.out.println(" }");
    }
}