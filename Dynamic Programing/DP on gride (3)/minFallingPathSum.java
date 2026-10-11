import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //edge case
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        //make dp matrix as -1
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -9999));

        int ans = Integer.MAX_VALUE;
        for(int j=0; j<matrix[0].length; j++){
            ans = Math.min(ans, minFallingPathSumGenerator(matrix, matrix.length-1, j, dp));
        }

        return ans;
    }

    public int minFallingPathSumGenerator(int[][] matrix, int i, int j, int[][] dp){
        if(i==0)return matrix[i][j];

        if( dp[i][j] != -9999 ) return dp[i][j];
        
        int l = Integer.MAX_VALUE;
        int m = l , r = l;

        if(j-1 >= 0) l = minFallingPathSumGenerator(matrix, i-1, j-1, dp);
        m = minFallingPathSumGenerator(matrix, i-1, j, dp);

        if(j+1 < matrix[0].length) r = minFallingPathSumGenerator(matrix, i-1, j+1, dp);

        return dp[i][j] = Math.min(l, Math.min(m, r)) + matrix[i][j];
    }

    //triangle problem
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;

        n = triangle.size();

        // sol1(triangle);
        return solution2(triangle);

    }   
    int n = 0;

    public int solution2(List<List<Integer>> triangle){
        //tabularization - best approach
        //tc: O(n^2) sc: O(n^2)

        int[][] dp = new int[n][triangle.get(n-1).size()];

        // Initialize the last row of the dp table
        for(int j=0; j<triangle.get(n-1).size(); j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        //because we are taking values from next dp row and adding with current triangle value
        // and going from n-2 to 0 row wise

        for(int i=n-2; i>=0; i--){         //ROW
            for(int j=0; j<triangle.get(i).size(); j++){    //COLUMN
                int l = Integer.MAX_VALUE;
                int r = l;

                //get value from next row
                l = dp[i+1][j];
                r = dp[i+1][j+1];

                dp[i][j] = Math.min(l, r) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
    public int solution3(List<List<Integer>> triangle){
        //tabularization - inplace - optimal only for space complexity
        //tc: O(n^2) sc: O(1)

        for(int i=n-2; i>=0; i--){         //ROW
            for(int j=0; j<triangle.get(i).size(); j++){    //COLUMN
                int l = Integer.MAX_VALUE;
                int r = l;

                //get value from next row
                l = triangle.get(i+1).get(j);
                r = triangle.get(i+1).get(j+1);

                triangle.get(i).set(j, Integer.valueOf(Math.min(l, r) + triangle.get(i).get(j)));
            }
        }

        return triangle.get(0).get(0);
    }

    public int sol1(List<List<Integer>> triangle) {
        //recursion + memoization
        //tc: O(n^2) sc: O(n^2)
        if(triangle == null || triangle.size() == 0) return 0;

        List<List<Integer>> dp = new ArrayList<>();

        //fill with -999
        for(int i=0; i<triangle.size(); i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<triangle.get(i).size(); j++){
                temp.add(-9999);
            }
            dp.add(temp);
        }

        return minimumTotalGenerator(triangle, triangle.size()-1, 0, dp);
    }

    public int minimumTotalGenerator(List<List<Integer>> triangle, int i, int j, List<List<Integer>> dp){
        if(i==0) return triangle.get(i).get(j);//base case

        if( dp.get(i).get(j) != -9999 ) return dp.get(i).get(j);//memoization
        
        int l = Integer.MAX_VALUE;
        int r = l;

        if(j-1 >= 0) l = minimumTotalGenerator(triangle, i-1, j-1, dp);
        if(j < (triangle.get(i).size()-1)) r = minimumTotalGenerator(triangle, i-1, j, dp);

        dp.get(i).set(j, Math.min(l, r) + triangle.get(i).get(j));

        return dp.get(i).get(j);
    }

}

class minFallingPathSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));

        System.out.println(s.minimumTotal(triangle));//output should be 11
    }
}