import java.util.Arrays;

class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        robGenerator(n - 1, nums, dp);
        robGenerator(n - 2, nums, dp);

        return Math.max(dp[n - 1], dp[n - 2]);
    }

    public int robGenerator(int ind, int[] nums, int[] dp) {
        if (ind <= 1) return nums[ind];     //recursion base case

        if (dp[ind] != -1) return dp[ind];  //memoization check

        int left = robGenerator(ind - 2, nums, dp) + nums[ind];
        int right = -1;
        if (ind > 2) {
            right = robGenerator(ind - 3, nums, dp) + nums[ind];
        }

        //check and store the maximum robbed amount in dp array
        return dp[ind] = (Math.max(left, right));
    }

    //dp - > tabulation
    public int robTabulation(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(nums[0] + nums[2], nums[1]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
        }

        return Math.max(dp[n - 1], dp[n - 2]);
    }
}

public class houseRobber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1};
        int maxRobbedAmount = solution.rob(nums);
        System.out.println("Maximum amount that can be robbed: " + maxRobbedAmount); //should print 4
    }
}
