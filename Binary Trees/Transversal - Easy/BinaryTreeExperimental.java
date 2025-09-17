import java.util.Stack;

public class BinaryTreeExperimental {
    private static void inorderIterative2(Node root) {
        // basic idea by brain
        if (root == null)
            return; // edge case

        Stack<Node> st = new Stack<>();
        int last_printed = Integer.MIN_VALUE; // safer than 0
        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();

            // Leaf node -> print directly
            if (curr.left == null && curr.right == null) {
                System.out.println(curr.data);
                last_printed = curr.data;
            } else {
                // ✅ Only expand curr if its left hasn’t been printed yet
                if (curr.left != null && curr.left.data == last_printed) {
                    // Left subtree already printed -> now print curr
                    System.out.println(curr.data);
                    last_printed = curr.data;
                    // and process right next
                    if (curr.right != null)
                        st.push(curr.right);
                } else {
                    // Expand normally
                    if (curr.right != null)
                        st.push(curr.right);
                    st.push(curr); // push current to revisit later
                    if (curr.left != null)
                        st.push(curr.left);
                }
            }
        }
    }

    private static int hight(Node node, int max) {
        if (node.right == null && node.left == null)
            return max;

        int mxL = 0, mxR = 0;

        if (node.left != null)
            mxL = hight(node.left, (max + 1));
        if (node.right != null)
            mxR = hight(node.right, (max + 1));

        return Math.max(mxL, mxR);
    }
}
