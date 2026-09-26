class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if(x == 0 || x == 1) return x;

        if(n < 0){
            x = 1/x;
            n = -(n+1);    //for Integer.MIN_VALUE
            ans = ans * x;
        }
        while(n>0){
            if(n%2==1){
                ans = ans * x;
                n--;
            }
            else{
                n=n/2;
                x=x*x;
            }

        }

        return ans;
    }
}

public class pow{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, 10));    // 1024.00000
        System.out.println(solution.myPow(2.10000, 3));
        System.out.println(solution.myPow(2.00000, -2));
    }
}