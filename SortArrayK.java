class SortArrayK {

    // https://medium.com/basecs/counting-linearly-with-counting-sort-cd8516ae09b3 
    public static int[] sortArrayK(int[] A, int k) {
        int[] map = new int[k + 1];
        for (int i = 0; i < A.length; i++) {
            map[A[i]]++;
        }

        int j = 0;
        for (int i = 0; i < k + 1; i++) {
            while (map[i]-- > 0) {
                A[j++] = i;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{ 8, 9, 10, 0 };
        int k = 10;
        int[] sorted = sortArrayK(A, k);
        System.out.print("{");
        for (int i : sorted) {
            System.out.print(i + ",");
        }
        System.out.println("}");
    }
}