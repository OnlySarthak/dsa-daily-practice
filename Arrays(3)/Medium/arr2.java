public class arr2 {
    //sort the array of 0,1,2

    public void sortColors(int[] nums) {
        //optimal solution
        //dutch flag algorithm
        
        int low= 0;
        int high = nums.length -1;
        int mid = 0;    //mid is basically iterator/i

        while(mid <= high){
            
            //if mid is 0 then move to left side 
            if(nums[mid]==0){
                swap(nums, low, mid);
                low++;  mid++;
                continue;
            }

            //if mid is 1 move on
            if(nums[mid]==1){
                mid++;
                continue;
            }

            //if mid is two the move it to right side and again resolve mid 
            if(nums[mid]==2){
                swap(nums, mid, high);
                high--;
            }
        }
    
    }

    public void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
