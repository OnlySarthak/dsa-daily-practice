// package Stack and Queues.Monotonic stack and queue;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        // Traversal from right to left using Monotonic Stack
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            
            // Map the current number directly to its next greater element
            map.put(nums2[i], st.isEmpty() ? -1 : st.peek());
            
            st.push(nums2[i]);
        }


        // Build result for nums1
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}

class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {       //optimal approach
        //pass 1 : monotonus stack
        HashMap<Integer, Integer> map = monotonusStackToHMGenerator(nums2);
        //pass 3: generate ans
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
    
    public HashMap<Integer, Integer> monotonusStackToHMGenerator(int[] arr) {
        int n = arr.length;
        
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = n-1; i >= 0; i--) {
            if(st.isEmpty()) {
                map.put(arr[i], -1);
                st.push(arr[i]);
            } else if(st.peek() > arr[i]) {
                map.put(arr[i], st.peek());
                st.push(arr[i]);
            } else {
                while(!st.isEmpty() && st.peek() <= arr[i]) {
                    st.pop();
                }
                map.put(arr[i], st.isEmpty() ? -1 : st.peek());
                st.push(arr[i]);
            }
        }
        return map;
    }

}
public class nextGreaterElement{}