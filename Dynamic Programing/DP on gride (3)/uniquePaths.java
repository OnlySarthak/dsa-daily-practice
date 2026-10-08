import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return uniquePathGenerator(m - 1, n - 1, dp);
    }

    public int uniquePathGenerator(int m, int n, int[][] dp) {
        // Base case: Reached top-left corner
        if (m == 0 && n == 0) return 1;

        // Memoization lookup
        if (dp[m][n] != -1) return dp[m][n];

        int up = 0;
        int left = 0;

        // Go UP if not on top row
        if (m > 0) {
            up = uniquePathGenerator(m - 1, n, dp);
        }

        // Go LEFT if not on leftmost column
        if (n > 0) {
            left = uniquePathGenerator(m, n - 1, dp);
        }

        return dp[m][n] = up + left;
    }
}