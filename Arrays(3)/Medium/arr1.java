import java.util.HashMap;

class arr1 {
    //two sum , array where two element serching whos sumession should == target

    public int[] twoSum(int[] nums, int target) {
        //better
        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j<nums.length; j++){
                if( (nums[i]+nums[j]) == target){
                    return (new int[] {i,j});
                }
            }
        }

        return new int[] {};
    }

    public int[] twoSum2(int[] nums, int target) {

        //optimal
        HashMap<Integer, Integer> map = new HashMap<>();
        int need;

        for(int i=0; i<nums.length ; i++){
            need = target - nums[i];

            if(map.containsKey(need)){
                return new int[] {i, map.get(need)};
            }

            map.put(nums[i] , i);
        }

        return new int[] {};
    }

    public int[] twoSum3(int[] nums, int target) {
        // slightly more optimal...not submittabel for leetcode coz indexes are changed after sorting
        int sum, L = 0, R = nums.length-1;
 
        mergeSort(nums);
 
        while(L<R){
             sum = nums[L] + nums[R];
 
             //found
             if(sum == target)return (new int[] {L , R});
 
             //else part
             if(sum < target)L++;          //  if sum less then L++
             else R--;                       // else Dec R
        }
 
         return new int[] {};
     }

     public void mergeSort(int[] arr){}static {//demod function
        }
}
