// github.com/kdn251/interviews/
class Main {
    public static void main(String[] args) throws Exception {
        runSorts();
    }

    private static void runSorts() {
        int[] arr = init();
        System.out.print("Initial");
        print(arr);
        Sort mergeSort = new MergeSort();
        int[] sorted = mergeSort.sort(arr);
        System.out.print("Merge Sort Sorted");
        print(sorted);

        arr = init();
        System.out.print("Initial");
        print(arr);
        Sort bubbleSort = new BubbleSort();
        sorted = bubbleSort.sort(arr);
        System.out.print("Bubble Sort Sorted");
        print(sorted);

        arr = init();
        System.out.print("Initial");
        print(arr);
        Sort selectionSort = new SelectionSort();
        sorted = selectionSort.sort(arr);
        System.out.print("Selection Sort Sorted");
        print(sorted);

        arr = init();
        System.out.print("Initial");
        print(arr);
        Sort qs = new QuickSort();
        sorted = qs.sort(arr);
        System.out.print("Quick Sort Sorted");
        print(sorted);
    }

    private static void print(int[] arr) {
        System.out.println(":");
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println("]");
    }

    private static int[] init() {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) Math.floor(Math.random() * 25 + 1);
        }
        return a;
    }
}
