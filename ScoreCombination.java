// LC 528
class ScoreCombination {
    
    static int footballScoreCombinations(int score) {
        int[] scores = new int[] { 2, 3, 7 };
        int[][] memo = new int[scores.length + 1][score + 1];
        for (int i = 1; i < scores.length + 1; i++) { // i = score type avail (2,3,7)
            for (int j = 1; j < score + 1; j++) { // j = curr points/score
                if (scores[i - 1] > j) {
                    memo[i][j] = memo[i - 1][j];
                    continue;
                }
                memo[i][j] = memo[i][j - scores[i - 1]] + 1; // missing something
            }
        }
        return memo[scores.length - 1][score - 1];
    }

    public static void main(String[] args) {
        int score = 12;
        System.out.println("# of score combinations for " + score + " points:");
        System.out.println(footballScoreCombinations(score));
    }
}