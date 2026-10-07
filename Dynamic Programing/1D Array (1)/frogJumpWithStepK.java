class Solution {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpGenerator(n - 1,k-1, heights, dp);
    }

    public int frogJumpGenerator(int ind,int k, int[] heights, int[] dp) {
        if(k < 0) return -1;
        if (ind == 0) return 0;

        if (dp[ind] != -1) return dp[ind];

        int left = frogJumpGenerator(ind - 1,k-1, heights, dp) ;
        if(left != -1) left += Math.abs(heights[ind] - heights[ind - 1]);
        else left  = Integer.MAX_VALUE;

        int right = Integer.MAX_VALUE;
        if (ind > 1) {
            right = frogJumpGenerator(ind - 2,k-1, heights, dp);
            if(right != -1) right += Math.abs(heights[ind] - heights[ind - 2]);
        }

        return dp[ind] = Math.min(left, right);
    }
}


public class frogJumpWithStepK {
    
}
