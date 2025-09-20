// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class findLowUppERBound {
    public static void main(String[] args) {
        int[] arr= { 1,2,3,3,5,8,8,10,10,11};
        System.out.println(lower_bound(arr,9));
        System.out.println(upper_bound(arr,9));
        System.out.println(floor(arr,9));
    }
    public static int upper_bound(int[] nums, int target) {
        int low = 0 ,high = nums.length-1,ans = nums.length;
        
        while(low <= high){
            int mid = (high + low)/2;
            
            if(nums[mid] > target){
                high = mid-1;
                ans = mid;
            }
            else low = mid+1;
        }
        
        return ans;
    }
    public static int lower_bound(int[] nums, int target) {
        int low = 0 ,high = nums.length-1,ans = nums.length;
        
        while(low <= high){
            int mid = (high + low)/2;
            
            if(nums[mid] >= target){
                high = mid-1;
                ans = mid;
            }
            else low = mid+1;
        }
        
        return ans;
    }
     public static int floor(int[] nums, int target) {
        int low = 0 ,high = nums.length-1,ans = -1;
        
        while(low <= high){
            int mid = (high + low)/2;
            
            if(nums[mid] >= target){
                high = mid-1;
                ans = mid;
            }else{
                low = mid +1;
            }
        }
        
        return ans;
    }
}