import java.util.Arrays;
class Solution {
    public int ninjaTraining(int[][] matrix) {
        int[][] dp = new int[matrix.length][3];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        int n = matrix.length;
        
        int max = 0;
        for(int i = 0; i < 3; i++){
            int temp = ninjasTrainingGenerator(n-1, i, matrix, dp);
            max = Math.max(max, temp);
        }

        return max;

    }

    private int ninjasTrainingGenerator(int r, int c, int[][] matrix, int[][] dp){
        if( r == 0 ) return matrix[r][c];

        if( dp[r][c] != -1 ) return dp[r][c];

        int left = 0, right = 0;
        if( c == 0 ){
            left = ninjasTrainingGenerator((r-1), 1, matrix, dp) + matrix[r][c];
            right = ninjasTrainingGenerator((r-1), 2, matrix, dp) + matrix[r][c];
        }
        else if( c == 1 ){
            left = ninjasTrainingGenerator((r-1), 0, matrix, dp) + matrix[r][c];
            right = ninjasTrainingGenerator((r-1), 2, matrix, dp) + matrix[r][c];
        } else {
            left = ninjasTrainingGenerator((r-1), 1, matrix, dp) + matrix[r][c];
            right = ninjasTrainingGenerator((r-1), 0, matrix, dp) + matrix[r][c];
        }
        
        return dp[r][c] = Math.max(left, right);
    }

    //dp - tabulation
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][3];

        // Base case: Day 0 choices
        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];

        // Fill table row by row
        for (int day = 1; day < n; day++) {
            dp[day][0] = matrix[day][0] + Math.max(dp[day - 1][1], dp[day - 1][2]);
            dp[day][1] = matrix[day][1] + Math.max(dp[day - 1][0], dp[day - 1][2]);
            dp[day][2] = matrix[day][2] + Math.max(dp[day - 1][0], dp[day - 1][1]);
        }

        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}

public class ninjasTraining {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
            {1, 2, 5},
            {3, 1, 1},
            {3, 3, 3}
        };
        int result = solution.ninjaTraining(matrix);
        System.out.println("Maximum points: " + result); //should print 11
    }
    
}
