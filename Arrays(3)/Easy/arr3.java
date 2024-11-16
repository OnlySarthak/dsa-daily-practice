//1752. Check if Array Is Sorted and Rotated(leetcode)

public class arr3 {
    public boolean check(int[] nums) {
        //better solution
        boolean flag = false;
        if(nums[0] >= nums[(nums.length -1)]) flag = true;
        
        for(int i=0; i<(nums.length-1) ; i++){
            if(nums[i] <= nums[i+1]){
                continue; 
            }
            else if(flag==true){
                 flag = false;
                 continue;
            }
            else{ return false;}
        }

        return true;
    }

    public boolean check2(int[] nums) {
        //optimal solution by leetcode

        int count=0;


       for(int i=1;i<nums.length;i++){
        if(nums[i-1]>nums[i]){
            count++;
        }
       }

       if(nums[nums.length-1]>nums[0]){
        count++;
       }
       
       return count<=1;     
    }

}
