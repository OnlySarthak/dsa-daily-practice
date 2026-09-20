class Solution {
    // sliding window approach - passed 151/170 before TLE
    public int consecutiveNumbersSum(int n) {
        if(n==1)return 1;

        int i = 1, j = 1, ans = 1, container = 0 ;
        while(i<=j && j<=n){
            if(container<n) container += j++;   
            else container -= i++;

            // verify
            if(container==n)ans++;
        }

        return ans;
    }
}

class consecutiveNumbersSum{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.consecutiveNumbersSum(5));
        System.out.println(s.consecutiveNumbersSum(9));
        System.out.println(s.consecutiveNumbersSum(15));
    }
}