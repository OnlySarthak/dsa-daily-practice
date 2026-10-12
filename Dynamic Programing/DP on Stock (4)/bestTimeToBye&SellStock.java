class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;

        int miniPrice = Integer.MAX_VALUE, maxiProfit = 0;
        
        for(int i=0; i<n; i++){
            //if current ele is minimum then update minimum Price
            miniPrice = Math.min(prices[i], miniPrice);

            //if current ele is making maximum profit then update maxi_profit
            maxiProfit = Math.max( (prices[i]-miniPrice), maxiProfit);
        }

        return maxiProfit;
    }

    public int maxProfit2(int[] prices){
        int n = prices.length, lastMax = prices[ (prices.length - 1) ];
        int ans = 0;

        for( int i = n-1 ; i >= 0; i-- ){
            int cost = lastMax - prices[i];
            ans = Math.max(ans,cost);
            lastMax = Math.max( lastMax, prices[i] );
        }

        return ans;        
    }
}

public class bestTimeToBye&SellStock {
    
}
