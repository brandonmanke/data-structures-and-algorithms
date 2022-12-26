class SubArraySum {

    // First try @ this problem [Max Subarray Sum]
    // So this works assuming that a 
    // non-continuous sequence in the array is considered
    // a subarray. Since we essentially borrowed the idea
    // from longest ___ subsequence problem.
    // Now we have to consider how to break when we see that it starts decreasing
    static int MaxSubsequenceSum(int[] A) {
        if (A.length == 0) return -1;
        if (A.length == 1) return A[0];
        int[] memo = A.clone();
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] + A[j] > A[i]) {
                    memo[i] = Math.max(memo[j] + A[i], memo[i]);
                }
            }
            max = Math.max(memo[i], max);
        }

        return max;
    }

    static int MaxSubArraySum(int[] A) {
        int minSum = 0;
        int runningSum = 0;
        int maxSum = 0;
        for (int i = 0; i < A.length; i++) {
            runningSum += A[i];
            if (runningSum < minSum)
                minSum = runningSum;

            if (runningSum - minSum > maxSum)
                maxSum = runningSum - minSum;
        }
        return maxSum;
    }



    public static void main(String[] args) {
        int[] A = new int[] { 904, 40, 523, 12, -335, -385, -124, 481, -31 };
        int maxSum = MaxSubArraySum(A);
        System.out.println("Max Subarray sum: " + maxSum);
        maxSum = MaxSubsequenceSum(A);
        System.out.println("Max Subsequence sum: " + maxSum);

    }
}