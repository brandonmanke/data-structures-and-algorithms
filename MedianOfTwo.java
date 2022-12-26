public class MedianOfTwo {

    public static double medianOfTwo(int[] a1, int[] a2) {
        return medianOfTwo(a1, 0, a1.length - 1, a2, 0, a2.length - 1);
    }

    public static double medianOfTwo(int[] a1, int lo1, int hi1, int[] a2, int lo2, int hi2) {

        // this part is slightly broken i think? not sure
        // still runs correctly for most? examples
        double median1 = getMedian(a1, lo1, hi1);
        double median2 = getMedian(a2, lo1, hi1);

        System.out.println("A1:" + median1);
        System.out.println("A2:" + median2);

        int mid1 = (lo1 + hi1) / 2;
        int mid2 = (lo2 + hi2) / 2;
        System.out.println("mid1: " + mid1 + " A1[mid1] = " + a1[mid1]);
        System.out.println("mid2: " + mid2 + " A2[mid2] = " + a2[mid2]);
        if (hi1 - lo1 + 1 <= 1 && hi2 - lo2 + 1 <= 1) return (double) (a1[mid1] + a2[mid2]) / 2;

        if (median1 > median2) {
            // new median in:
            // A1[1:median1]
            // OR
            // A2[median2:N]
            return medianOfTwo(a1, 0, mid1 - 1, a2, mid2 + 1, a2.length - 1);
        } else if (median1 < median2) {
            // new median in:
            // A1[median1:N]
            // OR
            // A2[1:median2]
            return medianOfTwo(a1, mid1 + 1, a1.length - 1, a2, 0, mid2 - 1);
        } else {
            // equal
            return median1;
        }
    }

    private static double getMedian(int[] A, int lo, int hi) {
        int len = hi - lo + 1;
        double median;
        System.out.println(len);
        if (len % 2 == 0) {
            median = (double) (A[lo + (len / 2)] + A[lo + ((len - 1) / 2)]) / 2;
        } else {
            median = A[lo + (len / 2)];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] a1 = { 1,2,3,4,5,6 };
        int[] a2 = { 12, 13, 22, 24, 31, 42 };
        System.out.println(medianOfTwo(a1, a2));
    }
}