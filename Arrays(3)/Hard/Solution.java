class Solution {
    //pascal nth term finingg functions
    public static int fact(int n){
        int ans = 1;
        while(n!=0){
            ans = n--*ans;
        }
        return ans;
    }
    public int findNth(int r, int c) {

        return fact(r-1) / (fact(c-1) * fact((r-1)-(c-1)));
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        System.out.println(sol.findNth(5, 3)); // Example test
        System.out.println(sol.findNth(4, 2)); // Another test
        System.out.println(sol.findNth(6, 1)); // Edge case (c=1)
        System.out.println(sol.findNth(6, 6)); // Edge case (c=r)
    }
}