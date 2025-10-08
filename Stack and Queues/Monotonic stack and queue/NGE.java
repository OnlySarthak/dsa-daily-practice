package Stack and Queues.Monotonic stack and queue;

import java.util.Stack;

public class NGE {
    public int[] nextGreaterElements(int[] arr) {       //optimal approach
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop all smaller or equal elements
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack is empty, no greater element
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            // Push current element
            st.push(arr[i]);
        }
        return ans;
    }

}