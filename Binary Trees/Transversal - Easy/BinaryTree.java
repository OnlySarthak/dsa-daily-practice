import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(11);
        boolean letTest = false;

        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(14);
        root.left.right = new Node(15);
        root.right.left = new Node(16);
        root.right.right = new Node(17);

        // root.right.right.right = new Node(17);

        // int[] maxi = new int[1]; // diameter holder
        // maxpath(root, maxi); // fills maxi[0]
        // System.out.println("maxpath = " + maxi[0]);

        boundryTraversal(root);

        if (letTest) {
            System.out.println("preorder :");
            preorderTransverse(root);
            System.out.println("\n inorder :");
            inorderTransverse(root);
            System.out.println("\n postorder :");
            postorderTransverse(root);
            System.out.println("\nlevel order :");
            levelOrderTraversel(root);
        }
    }

    private static void boundryTraversal(Node node) {
        if (node == null)
            return;

        // step 1 : print starting point(root)
        System.out.println(node.data);

        // print left side
        printLeftSide(node.left);

        // print right side excluding leave nodes
        printRightSideReversed(node.right);

    }

    public static void printLeftSide(Node left) {
        if (left == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(left);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Print leaf nodes or leftmost node of the level
                if (current.left == null && current.right == null || i == 0) {
                    System.out.println(current.data);
                }

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
    }

    public static void printRightSideReversed(Node right) {
        if (right == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(right);

        Stack<Integer> st = new Stack<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Push leaf nodes or rightmost node of level
                if (current.left == null && current.right == null || i == 0) {
                    st.push(current.data);
                }

                // Add right child first for true “rightmost-first reversed” effect
                if (current.right != null)
                    queue.add(current.right);
                if (current.left != null)
                    queue.add(current.left);
            }
        }

        // Print stack in reversed order
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    private static void zigzagTransversal(Node root) {
        if (root == null)
            return;

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        int latch = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // loop for one layer
            while (size != 0) {
                if (latch == 0) { // 0 then left to right
                    // fetch curren level L->R
                    Node currentNode = queue.removeFirst();
                    System.out.println(currentNode.data);

                    // add children node L->R
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else { // else right to left
                    // fetch curren level L<-R
                    Node currentNode = queue.removeLast();
                    System.out.print(currentNode.data + " ");

                    // add children node L<-R
                    if (currentNode.right != null)
                        queue.addFirst(currentNode.right);
                    if (currentNode.left != null)
                        queue.addFirst(currentNode.left);
                }
                size--;
            }
            System.out.println();

            // change latch for next iteration
            latch = 1 - latch;

        }
    }

    private static int diameter(Node node, int[] maxi) {
        if (node == null)
            return 0;

        int lh = diameter(node.left, maxi);
        int rh = diameter(node.right, maxi);

        maxi[0] = Math.max(maxi[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }

    public static boolean isSameTree(Node nodeT1, Node nodeT2) {
        if (nodeT1 == null && nodeT2 == null)
            return (nodeT1 == nodeT2);

        return (nodeT1.data == nodeT2.data) && isSameTree(nodeT1.left, nodeT2.left)
                && isSameTree(nodeT1.right, nodeT2.right);
    }

    private static int maxpath(Node node, int[] maxi) {
        if (node == null)
            return 0;

        int lh = maxpath(node.left, maxi);
        int rh = maxpath(node.right, maxi);

        // max is current or old
        maxi[0] = Math.max(maxi[0], (node.data + lh + rh));

        // sama as max height but with value
        return node.data + Math.max(lh, rh);
    }

    private static int heightBFS(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int height = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes in this level
            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            height++; // after finishing one level
        }

        return height;
    }

    private static int height(Node node) {
        if (node == null)
            return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private static int isBalancedTree(Node node) {
        if (node == null)
            return 0;

        int l = isBalancedTree(node.left);
        int r = isBalancedTree(node.right);

        if (l != -1 && r != -1 && Math.abs(l - r) <= 10)
            return (Math.max(l, r) + 1);

        return -1;
    }

    private static void postorderItertive(Node root) {
        if (root == null)
            return;

        Stack<Node> st = new Stack<>();
        Stack<Node> printingOrderStack = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();
            printingOrderStack.push(curr);

            if (curr.left != null)
                st.push(curr.left);
            if (curr.right != null)
                st.push(curr.right);
        }

        while (!printingOrderStack.isEmpty()) {
            System.out.println(printingOrderStack.pop().data);
        }
    }

    private static void levelOrderTraversel(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.data);

            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
    }

    private static void preorderIterative(Node root) {
        if (root == null)
            return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.println(curr.data);

            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);
        }
    }

    private static void inorderIterative(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.println(curr.data);
            curr = curr.right;
        }
    }

    private static void inorderTransverse(Node node) {
        if (node == null)
            return;
        inorderTransverse(node.left);
        System.out.print(node.data + " ");
        inorderTransverse(node.right);
    }

    private static void postorderTransverse(Node node) {
        if (node == null)
            return;
        postorderTransverse(node.left);
        postorderTransverse(node.right);
        System.out.print(node.data + " ");
    }

    private static void preorderTransverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorderTransverse(node.left);
        preorderTransverse(node.right);
    }
}
