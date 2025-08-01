public class findXInSortedRotated {
    public int search(int[] nums, int target) {
         int n = nums.length;
        int l = 0, h = n-1, ans = -1;
        
        //find pivot
        while(l <= h){
            int mid = (l+h)/2;
            
            if(nums[mid] == target)return mid;
            //if left half is sorted
            if(nums[l] <= nums[mid]){
                //if target lies in this half then eliminate other half
                if(nums[l] <= target && target <= nums[mid] ){
                    h = mid-1;
                }else{  //else eliminate this half
                    l = mid+1;
                }
            }else{  //else 
                //if target lies in this half then eliminate other half
                if(nums[mid] <= target && target <= nums[h] ){
                    l = mid+1;
                }else{  //else eliminate this half
                    h = mid-1;
                }
            }
        }
        
        return -1;
    }
}
