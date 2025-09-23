import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//tedha hai par mera hai

public class BinaryTreeExperimental {
    public static void printLeftSide(Node left) {
        if (left == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(left);

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process each level
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left == null && current.right == null) {
                    System.out.println(current.data);
                    continue;
                }

                // Print first node of level or leaf node
                if (i == 0 || (current.left == null && current.right == null)) {
                    System.out.println(current.data);
                }

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
    }

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

    private static void hightIterative(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> arr = new ArrayList<>();
        int arrPtr = -1;
        arr.add(1);
        int max = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            arrPtr++;
            int currHight = arr.get(arrPtr);
            max = Math.max(currHight, max);

            System.out.println(currentNode.data);

            if (currentNode.left != null) {
                arr.add(currHight + 1);
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                arr.add(currHight + 1);
                queue.add(currentNode.right);
            }
        }

        System.out.println(arr);
        System.out.println("Highest" + max);
    }

    private static int heightIterative2(Node root) {
        // very efficient
        /*
         * ✅ Time complexity → O(N), because each node is enqueued and dequeued once.
         * 
         * ✅ Space complexity → O(W), where W = max width of the tree (same as standard
         * BFS).
         */
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int height = 0;
        int countdown = 1; // how many nodes remain in this level
        int tempCtr = 0; // how many nodes we add for next level

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            countdown--; // one node processed from this level

            // Add children for next level
            if (current.left != null) {
                queue.add(current.left);
                tempCtr++;
            }
            if (current.right != null) {
                queue.add(current.right);
                tempCtr++;
            }

            // If this level is fully processed
            if (countdown == 0) {
                height++; // one level finished
                countdown = tempCtr; // move to next level
                tempCtr = 0; // reset counter
            }
        }

        return height;
    }

}
