class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //edge cases
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        // make all cell to -1 to indicate that they are not yet computed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return uniquePathGenerator(n - 1, m - 1, obstacleGrid, dp);
    }

    public int uniquePathGenerator(int m, int n, int[][] obstacleGrid, int[][] dp) {
        // Base case: Reached top-left corner
        if (m == 0 && n == 0) return 1;

        //obstacle case
        if (obstacleGrid[m][n] == 1) return 0;
        // Memoization lookup
        if (dp[m][n] != -1) return dp[m][n];
        
        int up = 0;
        int left = 0;
        
        // Go UP if not on top row
        if (m > 0) up = uniquePathGenerator(m - 1, n, obstacleGrid, dp);
        
        // Go LEFT if not on leftmost column
        if (n > 0) left = uniquePathGenerator(m, n - 1, obstacleGrid, dp);

        return dp[m][n] = up + left;
    }
}

public class uniquePathsWithObstacles{
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        //output: 2
        System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
    }
}