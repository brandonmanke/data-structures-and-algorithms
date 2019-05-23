class MergeSort implements Sort {
    public MergeSort() {
        super();
    }

    public int[] sort(int[] arr) {
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] arr, int[] aux, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, aux, low, mid);
            mergeSort(arr, aux, mid + 1, high);
            merge(arr, aux, low, mid, high);
        }
    }

    private void merge(int[] arr, int[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = arr[i];
        }

        int left = low;
        int i = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (aux[left] <= aux[right]) {
                arr[i] = aux[left++];
            } else {
                arr[i] = aux[right++];
            }
            i++;
        }

        for (int j = 0; j <= (mid - left); j++) {
            arr[i + j] = aux[left + j];
        }
    }
}
