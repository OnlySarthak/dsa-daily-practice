import java.util.*;

class Solution {
    public int[] nextGreaterElements2(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 2*n-1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i%n]) {
                st.pop();
            }
            ans[i%n] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i%n]);
        }
        return ans;
    }
}

public class nextGreaterElement2 {}