
import java.util.Arrays;

class Solution {
    //vannila recursion
    public int climbStairs1(int ind) {
        if ( ind == 0 || ind == 1 )  return 1;// Base cases
        return climbStairs1(ind-1) + climbStairs1(ind-2);
    }

    //dp - memorization
    int[] dp = new int[46];
    //my
    public int climbStairs2(int ind) {
        if ( ind == 0 || ind == 1 )  return 1;// Base cases
 
        if( dp[ind] == -1 ){
            dp[ind] = climbStairs2(ind-1) + climbStairs2(ind-2);
        } 

        return dp[ind];
    }

    // /standard
    public int climbStairs3(int ind) {
        if (ind == 0 || ind == 1) return 1; // Base cases
 
        // 1. Check memoization cache first
        if (dp[ind] != -1) return dp[ind];

        // 2. Compute and store result
        return dp[ind] = climbStairs2(ind - 1) + climbStairs2(ind - 2);
    }

    //dp - tabularization
    public int climbStairs4(int n) {
        if (n == 0 || n == 1) return 1; // Base cases

        int[] dp = new int[n + 1];
        dp[0] = 1; // One way to climb 0 stairs
        dp[1] = 1; // One way to climb 1 stair

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Recurrence relation
        }

        return dp[n];
    }

    public int climbStairsX(int n){//for my dp soln
        if ( n == 0 || n == 1 )  return 1;
        Arrays.fill(dp, -1);
        climbStairs2(n);
        return dp[n];
    }

    public int climbStairs(int n) {//for standard dp memorization soln
        Arrays.fill(dp, -1);
        return climbStairs3(n);
    }


}

public class climbingStairs {
        public static void main(String[] args) {
                Solution s = new Solution();
                System.out.println(s.climbStairs(1));
                System.out.println(s.climbStairs(3));
                System.out.println(s.climbStairs(5));
        }
}
