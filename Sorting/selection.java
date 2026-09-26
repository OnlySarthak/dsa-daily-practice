public class Solution {
    public int[] selectionSort(int[] nums) {
        int n = nums.length;

        int curr = 0, finder = 0;

        while(curr!=n){
            for(finder = curr+1; finder < n ; finder++){
                if(nums[curr] > nums[finder]){
                    int temp = nums[finder];
                    nums[finder] = nums[curr];
                    nums[curr] = temp; 
                }
            }
            curr++;
        }

        return nums;
    }
}