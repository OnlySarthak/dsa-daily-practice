class Solution {
    public int maxProfit(int[] prices) {
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

}

public class bestTimeToBye&SellStock2 {
    
}
