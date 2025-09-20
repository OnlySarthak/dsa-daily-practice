class arr4{
    // find min subarray with maximum sum

    public int maxSubArray(int[] nums) {
        //optimal soln: kadane algorith
       int sum = 0;
       int maxi = Integer.MIN_VALUE;

       for (int i = 0; i < nums.length; i++) {
           sum += nums[i];

           //if sum is greater than maxi then update maxi
           maxi = (sum > maxi)? sum : maxi;

           //if current no is making summetion -ve then update sum
           sum = (sum < 0)? 0 : sum;
       }

       return maxi;
    }

    public static void maxSubArray2(int[] nums) {
        //same function with print subarray feature

        int start=0, end = -1,ansStart = 0;
       int sum = 0;
       int maxi = Integer.MIN_VALUE;

       for (int i = 0; i < nums.length; i++) {
            if(sum==0)start = i;

           sum += nums[i];

           //if sum is greater than maxi then update maxi
           if(sum > maxi){
                maxi = sum;
                ansStart = start;
                end = i;
           }

           //if current no is making summetion -ve then update sum
           if(sum < 0) sum = 0;
       }

       for (int i = ansStart; i <= end; i++) {
           System.out.println(nums[i]);
       }
       System.out.println("Summetion is "+maxi);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
maxSubArray2(nums);  
    }
}