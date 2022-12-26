class QuickSort implements Sort {
    public QuickSort() {
        super();
    }

    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        final int pivotIndex = high;
        final int pivot = arr[pivotIndex];
        int curr = low; // lower bound / wall
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                swap(arr, curr, i);
                curr++;
            }
        }
        swap(arr, curr, pivotIndex);
        return curr;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*private static void print(int[] arr) {
        System.out.print("[");
        for (int i : arr)
            System.out.print(i + ",");
        System.out.println("]");
    }*/
}
