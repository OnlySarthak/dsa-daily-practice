class Solution {
    public int numSubseq(int[] nums, int target) {
        return numSubSeqGenerator(nums, target, 0, 0);
    }

    public int numSubSeqGenerator(int[] nums, int target, int index, int currentSum){
        if(index == nums.length){
            if(currentSum <= target){
                return 1;
            } else {
                return 0;
            }
        } else {
            int includeCurrent = numSubSeqGenerator(nums, target, index + 1, currentSum + nums[index]);
            int excludeCurrent = numSubSeqGenerator(nums, target, index + 1, currentSum);
            return includeCurrent + excludeCurrent; 
        }
    }
}