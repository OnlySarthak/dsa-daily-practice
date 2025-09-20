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

        root.left = new Node(13);
        root.right = new Node(14);
        root.left.left = new Node(15);

        root.right.right = new Node(16);
        root.right.right.right = new Node(17);

        int[] maxi = new int[1]; // diameter holder
        maxpath(root, maxi); // fills maxi[0]
        System.out.println("maxpath = " + maxi[0]);

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

    private static int diameter(Node node, int[] maxi) {
        if (node == null)
            return 0;

        int lh = diameter(node.left, maxi);
        int rh = diameter(node.right, maxi);

        maxi[0] = Math.max(maxi[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }

    private static int maxpath(Node node, int[] maxi) {
        if (node == null)
            return 0;

        int lh = maxpath(node.left, maxi);
        int rh = maxpath(node.right, maxi);

        // max is current or old
        maxi[0] = Math.max(maxi[0], (node.data + lh + rh));

        //sama as max height but with value
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
