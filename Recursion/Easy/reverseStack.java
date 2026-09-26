import java.util.Stack;

class Solution {
    public void reverseStack(Stack<Integer> st) {
        int n = st.size();
        // Outer loop (Passes): Do it n times (n, n-1, n-2, ... 1)
        bubbleSortPasses(st, n);
    }

    // Outer loop: Runs 'count' passes
    private void bubbleSortPasses(Stack<Integer> st, int count) {
        if (count <= 1) return;

        // One pass: Bubble the top element down through 'count' levels
        bubbleDown(st, count);

        // Next pass: Do it for n-1 items
        bubbleSortPasses(st, count - 1);
    }

    // Inner loop: Recursively bubble/swap top element down 'depth' steps
    private void bubbleDown(Stack<Integer> st, int depth) {
        if (depth <= 1 || st.size() < 2) return;

        // Step 1: Pop two elements
        int top1 = st.pop();
        int top2 = st.pop();

        // Step 2: Swap them! (Put top1 under top2)
        st.push(top1);

        // Step 3: Recurse to pass top1 further down
        bubbleDown(st, depth - 1);

        // Step 4: Put top2 back on top
        st.push(top2);
    }
}

public class reverseStack {
    public static void main(String[] args) {
        Solution s = new Solution();
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3); // Stack top is 3 -> [1, 2, 3]

        System.out.println("Before: " + st);
        s.reverseStack(st);
        System.out.println("After:  " + st); // Reversed -> [3, 2, 1]
    }
}