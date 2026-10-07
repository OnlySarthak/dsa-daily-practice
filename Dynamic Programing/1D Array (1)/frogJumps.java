import java.util.Arrays;

class Solution {

    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpGenerator(n - 1, heights, dp);
    }

    public int frogJumpGenerator(int ind, int[] heights, int[] dp) {
        if (ind == 0) return 0;

        if (dp[ind] != -1) return dp[ind];

        int left = frogJumpGenerator(ind - 1, heights, dp) + Math.abs(heights[ind] - heights[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1) {
            right = frogJumpGenerator(ind - 2, heights, dp) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return dp[ind] = Math.min(left, right);
    }
}