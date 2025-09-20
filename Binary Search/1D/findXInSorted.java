public class findXInSorted {

    public int recursive_search(int[] nums, int target, int low, int high){
    if(low > high) return -1;

    int mid = low + (high - low) / 2;

    if(nums[mid] == target) return mid;
    else if(nums[mid] > target) 
        return recursive_search(nums, target, low, mid - 1);
    else 
        return recursive_search(nums, target, mid + 1, high);
}

}