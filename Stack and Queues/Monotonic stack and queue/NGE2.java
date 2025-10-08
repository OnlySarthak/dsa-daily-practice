import java.util.*;

public class NGE2 {
    public static int[] nextGreaterElements(int[] nums) {       //by me...hybrid and infficient
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        TreeSet<Integer> tree = new TreeSet<>();

        // Step 1: Classic monotonic stack for circular array (simulate 2n traversal)
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!st.isEmpty() && nums[st.peek()] < nums[idx]) {
                ans[st.pop()] = nums[idx];
            }
            if (i < n) st.push(idx);
            tree.add(nums[idx]);  // build TreeSet of all elements
        }

        // Step 2: Only check -1 entries in ans using TreeSet
        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) {
                Integer higher = tree.higher(nums[i]);
                if (higher != null) ans[i] = higher;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(nums))); // [2,3,4,-1,4]
    }
}
