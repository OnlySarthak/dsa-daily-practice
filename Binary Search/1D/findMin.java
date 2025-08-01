public class findMin {
    public static void main(String[] args) {
        findMin sol = new findMin();
        System.out.println("hi");
        int[] nums1 = {3, 1,2};
        System.out.println(sol.search(nums1, 3)); // expected 0

        int[] nums2 = {1, 3};
        System.out.println(sol.search(nums2, 3)); // expected 1

        int[] nums3 = {5, 6, 7, 1, 2, 3, 4};
        System.out.println(sol.search(nums3, 2)); // expected 4
    }
    public int search(int[] nums, int target) {
         int n = nums.length;
        int l = 0, h = n-1;
        
        if(n==2){
            return (nums[0] < nums[1] ? 0 : 1);
        }
        
        //find pivot
        while(l < h){
            int mid = (l+h)/2;
            
            //if right is sorted
            if(nums[mid] <= nums[h]){
                h = mid;
            }else{
                l = mid+1;
            }
        }
        
        return l;
    }
}
