class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int need = 1,j = n - 2;

        while(j!=-1){
            System.out.println("j: "+j+ "nums[j]: "+nums[j]+" need: "+need);
            if(nums[j] >= need){
                need = 1;
            }else{
                need++;
            }
            j--;
        }
        return need == 1;
    }
}

public class jumpGame {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,0,0};
        System.out.println(s.canJump(nums));
    }
}