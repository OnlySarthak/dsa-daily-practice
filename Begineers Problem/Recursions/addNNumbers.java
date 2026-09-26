class Solution {
    public int arraySum(int[] nums) {
        return engin(nums, nums.length-1);
    }

    public int engin(int[] nums, int i){
        if(i==0)return nums[0];
        return nums[i]+engin(nums,i-1);
    }
}

public class addNNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.arraySum(nums));
    }
}
