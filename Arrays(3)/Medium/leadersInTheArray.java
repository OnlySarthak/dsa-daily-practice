class Solution {
    public List<Integer> leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
    
        int LastBigger = nums[nums.length - 1];
        ans.add(LastBigger); // O(1) time
    
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > LastBigger) {
                LastBigger = nums[i];
                ans.add(LastBigger); // O(1) time
            }
        }
    
        Collections.reverse(ans); // O(N) time once
        return ans; // Total Time: O(N), Space: O(1) auxiliary
    }
}
public class leadersInTheArray {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 2, 5, 3, 1, 2};
        System.out.println("Example 1 Output: " + solution.leaders(nums1));
        System.out.println("Expected Output:  [5, 3, 2]\n");

        // Example 2
        int[] nums2 = {-3, 4, 5, 1, -4, -5};
        System.out.println("Example 2 Output: " + solution.leaders(nums2));
        System.out.println("Expected Output:  [5, 1, -4, -5]");
    }
}