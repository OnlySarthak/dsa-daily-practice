import java.util.Arrays;

class Solution {
    // It's actually also a Greedy approach!
    // Your code uses the Peak-Valley / Local Minimum tracking strategy
    public int maxProfit(int[] prices) {
        //my solution | optimal
        int ans = 0, lastMin = prices[0];
        
        for(int i=1; i<prices.length; i++){
            if(prices[i-1] > prices[i]){
                ans += (prices[i-1] - lastMin);
                lastMin = prices[i];
            }
        }

        if(prices[prices.length-1] > lastMin){
            ans += (prices[prices.length-1] - lastMin);
        }
        
        return ans;
    }

    // This shorter greedy approach does the exact same thing: 
    // whenever tomorrow's price is higher than today's,
    //  you "buy" today and "sell" tomorrow, accumulating all profits. 
    // It avoids complex tracking of lastMin and extra conditions at the end
    //  of the array.
    public int maxProfit2(int[] prices) {
        //greedy solution | optimal
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    //as it is take - not take problem, we can use recurtion to solve it
    //recurtion solution | not optimal
    public int maxProfit3(int[] prices) {
        return helper(prices, 0, true);
    }
    public int helper(int[] prices, int index, boolean canBuy){
        if(index >= prices.length) return 0;
        int profit = 0;

        if(canBuy){
            //buy
            //after buy we can not buy again, so we will call helper with canBuy = false
            //instead of buying we can also skip the current index and check for next index with canBuy = true
            //this works as: [1,2,3] 0: 0-1 -> 1: skip -> 2: -1 + 3 -> 2 profit
            profit = Math.max(
                //buy
                -prices[index] + helper(prices, index+1, false),
                //skip
                0+ helper(prices, index+1, true));     
        }else{
            //sell
            profit = Math.max(
                //sell
                prices[index] + helper(prices, index+1, true), 
                //skip
                0+ helper(prices, index+1, false));
        }

        //buy -> sell -> buy -> sell
        //buy ->skip from sell -> sell
        //skip from buy -> buy -> sell
        //so at the end we have to buy and then sell
        //so we will return the max profit from all the above cases

        return profit;
    }

    //there is a lot of overlapping subproblems in the recurtion solution, 
    //so we can use memoization to store the results of subproblems 
    public int maxProfit4(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0; i<prices.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(prices, 0, true, dp);
    }

    public int helper(int[] prices, int index, boolean canBuy, int[][] dp){
        if(index >= prices.length) return 0;    //base case

        if(dp[index][canBuy ? 1 : 0] != -1) return dp[index][canBuy ? 1 : 0];


        int profit = 0;
        if(canBuy){
            //buy
            profit = Math.max(
                -prices[index] + helper(prices, index+1, false, dp),
                //skip
                0 + helper(prices, index+1, true, dp));
        }else{
            //sell
            profit = Math.max(prices[index] + helper(prices, index+1, true, dp), helper(prices, index+1, false, dp));
        }

        dp[index][canBuy ? 1 : 0] = profit;
        return profit;
    }

}

public class bestTimeToBye&SellStock2 {
    
}
